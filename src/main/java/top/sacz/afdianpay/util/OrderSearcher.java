package top.sacz.afdianpay.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import okhttp3.*;
import top.sacz.afdianpay.entiry.OrderPage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class OrderSearcher {

    private final String userId;

    private final String token;

    private String params;

    public OrderSearcher(String userId, String token) {
        this.userId = userId;
        this.token = token;
        //必须填入空参数，不然签名校验直接错误
        JSONObject nullParameters = new JSONObject();
        nullParameters.put("em", "");
        params = nullParameters.toJSONString();
    }

    /**
     * 设置请求参数 必须为JSON格式
     */
    public OrderSearcher setParams(String jsonParam) {
        this.params = jsonParam;
        return this;
    }

    /**
     * 根据订单号查询订单
     * @param outTradeNo 订单号,查询多个以,分割
     * @return 订单信息
     */
    public OrderPage queryOrder(String outTradeNo) {
        String url = "https://afdian.com/api/open/query-order";
        //设置参数
        JSONObject param = new JSONObject();
        param.put("out_trade_no", outTradeNo);
        setParams(param.toString());

        JSONObject response = JSONObject.parseObject(post(url, buildRequestParam()));
        JSONObject data = response.getJSONObject("data");
        return JSON.parseObject(data.toJSONString(), OrderPage.class);
    }

    /**
     * 分页查询订单,以创建时间倒序
     * @param page 页数
     * @return 页码
     */
    public OrderPage queryOrder(int page) {
        String url = "https://afdian.com/api/open/query-order";
        //设置参数
        JSONObject param = new JSONObject();
        param.put("page", page);
        setParams(param.toString());

        JSONObject response = JSONObject.parseObject(post(url, buildRequestParam()));
        JSONObject data = response.getJSONObject("data");
        return JSON.parseObject(data.toJSONString(), OrderPage.class);
    }

    public String checkSing() {
        String url = "https://afdian.com/api/open/ping";
        return post(url, buildRequestParam());
    }

    public String post(String url, String body) {
        OkHttpClient httpClient = new OkHttpClient().newBuilder().build();
        RequestBody requestBody = RequestBody.Companion.create(body, MediaType.parse("application/json"));
        Request request = new Request.Builder().url(url).post(requestBody).build();
        try (Response response = httpClient.newCall(request).execute()) {
            return response.body().string();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private String buildRequestParam() {
        JSONObject param = new JSONObject();
        param.put("params", params);
        param.put("user_id", userId);
        param.put("ts", System.currentTimeMillis() / 1000);
        param.put("sign", buildSing());
        return param.toJSONString();
    }

    private String buildSing() {
        String sing = "{token}params{params}ts{ts}user_id{user_id}";
        sing = sing.replace("{token}", token);
        sing = sing.replace("{user_id}", userId);
        //获取秒级时间戳
        sing = sing.replace("{ts}", String.valueOf(System.currentTimeMillis() / 1000));
        sing = sing.replace("{params}", params);
        return toMD5(sing);
    }

    private String toMD5(String str) {
        try {
            // 创建一个MessageDigest实例，指定算法为MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 将输入字符串转换成字节数组，然后进行摘要处理
            byte[] digest = md.digest(str.getBytes());
            // 创建一个StringBuilder对象用于构建MD5值的十六进制表示形式
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                // 将每个字节转换为十六进制，并追加到StringBuilder对象中
                sb.append(String.format("%02x", b));
            }
            // 返回构建好的MD5值
            return sb.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }
}
