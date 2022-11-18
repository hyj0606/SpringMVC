package com.pojo;

/**
 * @ClassName Goods
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-17 11:56
 * @Version 1.0
 */

public class Goods {
    private int id;
    private String goodsName;
    private double price;

    public Goods() {
    }

    public Goods(int id, String goodsName, double price) {
        this.id = id;
        this.goodsName = goodsName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
