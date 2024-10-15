package top.sacz.afdianpay.entiry;

import com.alibaba.fastjson2.JSON;

import java.util.List;

public class AiPayOrderRequestBody {

    private int ec;
    private String em;
    private Data data;

    public Data getData() {
        return data;
    }

    public String getEm() {
        return em;
    }

    public int getEc() {
        return ec;
    }


    public static class Data {
        private String type;
        private Order order;

        public String getType() {
            return type;
        }

        public Order getOrder() {
            return order;
        }
    }

    public static class Order {
        private String out_trade_no;
        private String user_id;
        private String plan_id;
        private Integer month;
        private String total_amount;
        private String show_amount;
        private Integer status;
        private String remark;
        private String redeem_id;
        private Integer product_type;
        private String discount;
        private List<SkuDetail> sku_detail;
        private Integer create_time;
        private String plan_title;
        private String user_private_id;
        private String address_person;
        private String address_phone;
        private String address_address;

        public String getAddress_person() {
            return address_person;
        }

        public String getAddress_phone() {
            return address_phone;
        }

        public String getAddress_address() {
            return address_address;
        }

        public String getUser_private_id() {
            return user_private_id;
        }

        public String getPlan_title() {
            return plan_title;
        }

        public Integer getCreate_time() {
            return create_time;
        }

        public List<SkuDetail> getSku_detail() {
            return sku_detail;
        }

        public String getDiscount() {
            return discount;
        }

        public Integer getProduct_type() {
            return product_type;
        }

        public String getRedeem_id() {
            return redeem_id;
        }

        public String getRemark() {
            return remark;
        }

        public Integer getStatus() {
            return status;
        }

        public String getTotal_amount() {
            return total_amount;
        }

        public String getShow_amount() {
            return show_amount;
        }

        public Integer getMonth() {
            return month;
        }

        public String getPlan_id() {
            return plan_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public static class SkuDetail {
            private String sku_id;
            private String price;
            private Integer count;
            private String name;
            private String album_id;
            private String pic;
            private String stock;
            private String post_id;

            public String getSku_id() {
                return sku_id;
            }

            public String getPrice() {
                return price;
            }

            public Integer getCount() {
                return count;
            }

            public String getName() {
                return name;
            }

            public String getAlbum_id() {
                return album_id;
            }

            public String getPic() {
                return pic;
            }

            public String getStock() {
                return stock;
            }

            public String getPost_id() {
                return post_id;
            }
        }
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
