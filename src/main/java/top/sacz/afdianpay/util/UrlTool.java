package top.sacz.afdianpay.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

class UrlTool {

    public static Map<String, String> parseUrlParam(String fullUrl) {
        try {
            URL url = new URL(fullUrl);
            Map<String, String> params = new LinkedHashMap<>();
            String[] pairs = url.getQuery().split("&");
            for (String pair : pairs) {
                int idx = pair.indexOf("=");
                String key = idx > 0 ? pair.substring(0, idx) : pair;
                String value = idx > 0 && pair.length() > idx + 1 ? pair.substring(idx + 1) : null;
                params.put(key, value);
            }
            return params;
        } catch (MalformedURLException e) {
            throw new RuntimeException("URL可能不合法：" + e);
        }
    }
}
