package top.sacz.afdianpay.entiry;

import com.alibaba.fastjson2.annotation.JSONField;

import java.util.List;

public class AfdianPayOrder {

    @JSONField(name = "ec")
    private Integer ec;
    @JSONField(name = "em")
    private String em;
    @JSONField(name = "data")
    private Data data;

    public Integer getEc() {
        return ec;
    }

    public void setEc(Integer ec) {
        this.ec = ec;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {

        @JSONField(name = "type")
        private String type;

        @JSONField(name = "order")
        private Order order;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Order getOrder() {
            return order;
        }

        public void setOrder(Order order) {
            this.order = order;
        }
    }

    public static class Order {

        /**
         * 订单号(爱发电自动生成)
         */
        @JSONField(name = "out_trade_no")
        private String outTradeNo;

        /**
         * 自定义订单号
         */
        @JSONField(name = "custom_order_id")
        private String customOrderId;

        /**
         * 赞助的用户id
         */
        @JSONField(name = "user_id")
        private String userId;

        /**
         * 赞助用户的唯一id
         */
        @JSONField(name = "user_private_id")
        private String userPrivateId;

        /**
         * 赞助商品id
         */
        @JSONField(name = "plan_id")
        private String planId;

        /**
         * 赞助月数
         */
        @JSONField(name = "month")
        private Integer month;

        @JSONField(name = "total_amount")
        private String totalAmount;

        @JSONField(name = "show_amount")
        private String showAmount;

        @JSONField(name = "status")
        private Integer status;

        @JSONField(name = "remark")
        private String remark;

        @JSONField(name = "redeem_id")
        private String redeemId;

        @JSONField(name = "product_type")
        private Integer productType;

        @JSONField(name = "discount")
        private String discount;

        @JSONField(name = "sku_detail")
        private List<SkuDetail> skuDetail;

        @JSONField(name = "address_person")
        private String addressPerson;

        @JSONField(name = "address_phone")
        private String addressPhone;

        @JSONField(name = "address_address")
        private String addressAddress;

        public String getOutTradeNo() {
            return outTradeNo;
        }

        public void setOutTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
        }

        public String getCustomOrderId() {
            return customOrderId;
        }

        public void setCustomOrderId(String customOrderId) {
            this.customOrderId = customOrderId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserPrivateId() {
            return userPrivateId;
        }

        public void setUserPrivateId(String userPrivateId) {
            this.userPrivateId = userPrivateId;
        }

        public String getPlanId() {
            return planId;
        }

        public void setPlanId(String planId) {
            this.planId = planId;
        }

        public Integer getMonth() {
            return month;
        }

        public void setMonth(Integer month) {
            this.month = month;
        }

        public String getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(String totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getShowAmount() {
            return showAmount;
        }

        public void setShowAmount(String showAmount) {
            this.showAmount = showAmount;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getRedeemId() {
            return redeemId;
        }

        public void setRedeemId(String redeemId) {
            this.redeemId = redeemId;
        }

        public Integer getProductType() {
            return productType;
        }

        public void setProductType(Integer productType) {
            this.productType = productType;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public List<SkuDetail> getSkuDetail() {
            return skuDetail;
        }

        public void setSkuDetail(List<SkuDetail> skuDetail) {
            this.skuDetail = skuDetail;
        }

        public String getAddressPerson() {
            return addressPerson;
        }

        public void setAddressPerson(String addressPerson) {
            this.addressPerson = addressPerson;
        }

        public String getAddressPhone() {
            return addressPhone;
        }

        public void setAddressPhone(String addressPhone) {
            this.addressPhone = addressPhone;
        }

        public String getAddressAddress() {
            return addressAddress;
        }

        public void setAddressAddress(String addressAddress) {
            this.addressAddress = addressAddress;
        }
    }

    public static class SkuDetail {
        @JSONField(name = "sku_id")
        private String skuId;
        @JSONField(name = "count")
        private Integer count;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "album_id")
        private String albumId;
        @JSONField(name = "pic")
        private String pic;

        public String getSkuId() {
            return skuId;
        }

        public void setSkuId(String skuId) {
            this.skuId = skuId;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlbumId() {
            return albumId;
        }

        public void setAlbumId(String albumId) {
            this.albumId = albumId;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }
}
