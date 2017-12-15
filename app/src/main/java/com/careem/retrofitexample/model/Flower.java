package com.careem.retrofitexample.model;

import com.google.gson.annotations.Expose;

/**
 * Created by hp on 12/14/2017.
 */

public class Flower {

    @Expose
    private String category;
    @Expose
    private String instructions;
    @Expose
    private String photo;
    @Expose
    private String name;
    @Expose
    private Double price;
    @Expose
    private int productId;

    public void setCategory(String category) {
        this.category = category;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price.toString();
    }

    public int getProductId() {
        return productId;
    }
}
