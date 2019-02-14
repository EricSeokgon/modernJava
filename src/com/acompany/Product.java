package com.acompany;

public class Product {
    private long producrId;
    private String title;
    private int price;
    private String createDate;

    public long getProducrId() {
        return producrId;
    }

    public void setProducrId(long producrId) {
        this.producrId = producrId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
