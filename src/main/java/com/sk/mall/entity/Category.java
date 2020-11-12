package com.sk.mall.entity;

public class Category {

    private Integer id;

    private String cateName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", cateName='" + cateName + '\'' +
                '}';
    }
}