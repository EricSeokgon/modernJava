package com.acompany.app;

import com.acompany.Product;

public class AppMain {
    public static void main(String[] args) {
        Product myProd = new Product();
        myProd.setProducrId(1);
        myProd.setPrice(2000);
        myProd.setTitle("갤럭시S8");
        myProd.setCreateDate("2020-08-15");
        System.out.println(myProd);
    }
}
