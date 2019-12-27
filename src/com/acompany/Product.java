package com.acompany;

public class Product {
    private long producrId;
    private String title;
    private int price;
    private String createDate;
    private String name;
    private int amount;

    public Product() {
    }

    public Product(long producrId, String title, int price, String createDate, String name, int amount) {
        this.producrId = producrId;
        this.title = title;
        this.price = price;
        this.createDate = createDate;
        this.name = name;
        this.amount = amount;
    }

    public Product(int amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "producrId=" + producrId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", createDate='" + createDate + '\'' +
                '}';
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
