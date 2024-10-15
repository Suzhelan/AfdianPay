package top.sacz.afdianpay;

import top.sacz.afdianpay.util.AfdianPayUrlBuilder;

public class CreateOrderTest {
    public static void main(String[] args) {
        //发电的付款页面
        String url = "https://ifdian.net/order/create?product_type=1&plan_id=2219e4d4660911efb2ee52540025c377&sku=%5B%7B%22sku_id%22%3A%22222481dc660911efa8ae52540025c377%22%2C%22count%22%3A1%7D%5D&viokrz_ex=0";
        //想要实现自定义订单号时
        String orderId = String.valueOf(System.currentTimeMillis());
        String payUrl = new AfdianPayUrlBuilder(url)
                .setRemark("自定义备注参数")
                .setCustomOrderId(orderId)
                .build();
        System.out.println(payUrl);
    }
}
