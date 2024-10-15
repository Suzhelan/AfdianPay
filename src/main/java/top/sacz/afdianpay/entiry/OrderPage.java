package top.sacz.afdianpay.entiry;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;


public class OrderPage {

    @JSONField(name = "list")
    private List<AfdianPayOrder.Order> list;

    @JSONField(name = "total_count")
    private Integer totalCount;

    @JSONField(name = "total_page")
    private Integer totalPage;

    /**
     * 获取订单列表
     */
    public List<AfdianPayOrder.Order> getList() {
        return list;
    }

    public OrderPage setList(List<AfdianPayOrder.Order> list) {
        this.list = list;
        return this;
    }

    /**
     * 获取总订单数量
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    public OrderPage setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    /**
     * 获取总页数
     */
    public Integer getTotalPage() {
        return totalPage;
    }

    public OrderPage setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
