package top.sacz.afdianpay.util;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AfdianPayUrlBuilder {

    private Map<String, String> params = new LinkedHashMap<>();

    public AfdianPayUrlBuilder() {
    }

    public AfdianPayUrlBuilder(String url) {
        params = UrlTool.parseUrlParam(url);
    }

    public AfdianPayUrlBuilder addSku(String skuId, int count) {
        //构造sdk对象
        JSONObject skuObject = new JSONObject();
        skuObject.put("sku_id", skuId);
        skuObject.put("count", count);
        //添加到sku列表
        JSONArray skuArray = new JSONArray();
        skuArray.add(skuObject);
        //添加到params,如果param里没有则创建一个
        if (params.containsKey("sku")) {
            skuArray = JSONArray.parseArray(params.get("sku"));
            params.put("sku", skuArray.toJSONString());
        } else {
            params.put("sku", skuObject.toJSONString());
        }
        return this;
    }


    public AfdianPayUrlBuilder setProductType(int productType) {
        params.put("product_type", String.valueOf(productType));
        return this;
    }

    public AfdianPayUrlBuilder setRemark(String remark) {
        params.put("remark", remark);
        return this;
    }

    public AfdianPayUrlBuilder setPlanId(String planId) {
        params.put("plan_id", planId);
        return this;
    }

    public AfdianPayUrlBuilder setCustomOrderId(String orderId) {
        params.put("custom_order_id", orderId);
        return this;
    }

    public String build() {
        checkAndCompleteParameters();
        StringBuilder url = new StringBuilder("https://ifdian.net/order/create?");
        // 拼接参数
        for (Map.Entry<String, String> entry : params.entrySet()) {
            url.append(entry.getKey()).append("=")
                    .append(entry.getValue())
                    .append("&");
        }
        url.deleteCharAt(url.length() - 1);
        return url.toString();
    }


    private void checkAndCompleteParameters() {
        //检查必须参数
        if (!params.containsKey("plan_id")) {
            throw new RuntimeException("缺少plan_id参数");
        }
        if (!params.containsKey("sku")) {
            throw new RuntimeException("缺少sku参数");
        }
        //检查非必须参数 如果没填那么我们自动补充
        if (!params.containsKey("product_type")) {
            params.put("product_type", "1");
        }
        if (!params.containsKey("viokrz_ex")) {
            params.put("viokrz_ex", "0");
        }
        if (!params.containsKey("remark")) {
            params.put("remark", "");
        }
    }

}
