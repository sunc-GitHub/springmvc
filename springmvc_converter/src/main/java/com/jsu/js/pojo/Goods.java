package com.jsu.js.pojo;

import java.util.Date;

/**
 * @author: sunc-idea
 * @Date: 2020/4/24
 */
public class Goods {
    private Integer id;
    private Double price;
    private Integer quantity;
    private Date date;

    public Goods() {
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
