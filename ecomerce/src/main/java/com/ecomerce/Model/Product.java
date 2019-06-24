package com.ecomerce.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "product")
public class Product
{
    @Id
    String id;
    @Indexed(unique = true)
    String name;
    float price;
    List<String> catagories;
    String img_url;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", catagories=" + catagories +
                ", img_url='" + img_url + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<String> getCatagories() {
        return catagories;
    }

    public void setCatagories(List<String> catagories) {
        this.catagories = catagories;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Product (String name, float price, List<String> catagories, String img_url) {
        this.name = name;
        this.price = price;
        this.catagories = catagories;
        this.img_url = img_url;
    }

    public Product() {
    }
}
