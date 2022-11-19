package com.kgisl.book.entity;

public class Product {
    private int product_id;
    private String product_name;
    private String product_quantity;
    private float product_price;
    private String pro_manufactured_date;
    private String pro_expiry_date;
   

   

    public Product(int product_id, String product_name, String product_quantity, float product_price,
            String pro_manufactured_date, String pro_expiry_date) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_quantity = product_quantity;
        this.product_price = product_price;
        this.pro_manufactured_date = pro_manufactured_date;
        this.pro_expiry_date = pro_expiry_date;
    }

    public Product(String product_name2, String product_quantity2, float product_price2, String pro_manufactured_date2,
            String pro_expiry_date2) {
    }

    public int getProduct_id() {
        return product_id;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public String getProduct_quantity() {
        return product_quantity;
    }
    public void setProduct_quantity(String product_quantity) {
        this.product_quantity = product_quantity;
    }
    public float getProduct_price() {
        return product_price;
    }
    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }
    public String getPro_manufactured_date() {
        return pro_manufactured_date;
    }
    public void setPro_manufactured_date(String pro_manufactured_date) {
        this.pro_manufactured_date = pro_manufactured_date;
    }
    public String getPro_expiry_date() {
        return pro_expiry_date;
    }
    public void setPro_expiry_date(String pro_expiry_date) {
        this.pro_expiry_date = pro_expiry_date;
    }
    


}
