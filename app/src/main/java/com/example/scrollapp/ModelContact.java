package com.example.scrollapp;
// Creatr  model class for data
public class ModelContact {
    private String id,name,image,amount,phone,Time,UpdateTime;

    public ModelContact(String id, String name, String image, String amount, String phone, String time, String updateTime) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.amount = amount;
        this.phone = phone;
        Time = time;
        UpdateTime = updateTime;
    }
//create constructor

    // create getter and setter method

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }
}
