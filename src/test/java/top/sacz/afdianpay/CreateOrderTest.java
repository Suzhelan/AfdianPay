package top.sacz.afdianpay;

import top.sacz.afdianpay.entiry.AfdianPayOrder;
import top.sacz.afdianpay.entiry.OrderPage;
import top.sacz.afdianpay.util.AfdianUtil;
import top.sacz.afdianpay.util.OrderSearcher;

import java.util.List;

public class CreateOrderTest {
    public static void main(String[] args) {

        OrderSearcher orderSearcher = AfdianUtil.newOrderSearcher("31e505d6a30b11eea4bf52540025c377", "DyVmKFnPHBfab7vxw3dUMTgsRqu95CEp");
        //查询第一页
        OrderPage orderPage = orderSearcher.queryOrder(1);
        //总页数
        int totalPage = orderPage.getTotalPage();
        //总订单数
        int totalCount = orderPage.getTotalCount();
        System.out.println("总页数:" + totalPage);
        System.out.println("总订单数:" + totalCount);
        //订单列表
        List<AfdianPayOrder.Order> list = orderPage.getList();
        for (AfdianPayOrder.Order order : list) {
            System.out.println("订单号:" + order.getOutTradeNo());
        }
    }
}
