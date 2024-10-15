package top.sacz.afdianpay.util;

import com.alibaba.fastjson2.JSONObject;
import top.sacz.afdianpay.entiry.AfdianPayOrder;

public class AfdianUtil {

    /**
     * 构造成功处理成功的结果
     *
     * @return {"ec":200,"em":""}
     */
    public static String returnSuccess() {
        JSONObject result = new JSONObject();
        result.put("ec", 200);
        result.put("em", "");
        return result.toJSONString();
    }

    /**
     * 解析订单信息
     *
     * @param body 爱支付发来的订单通知
     */
    public static AfdianPayOrder.Order parseOrder(String body) {
        return JSONObject.parseObject(body, AfdianPayOrder.class).getData().getOrder();
    }

    /**
     * 创建订单查询器
     *
     * @param userId 爱发电开发者id
     * @param token  爱发电开发者token
     */
    public static OrderSearcher newOrderSearcher(String userId, String token) {
        return new OrderSearcher(userId, token);
    }

    /**
     * 创建订单url生成器
     */
    public static AfdianPayUrlBuilder newPayUrlBuilder() {
        return new AfdianPayUrlBuilder();
    }

    /**
     * 创建订单url生成器
     *
     * @param url 爱支付支付页面地址
     */
    public static AfdianPayUrlBuilder newPayUrlBuilder(String url) {
        return new AfdianPayUrlBuilder(url);
    }

}
