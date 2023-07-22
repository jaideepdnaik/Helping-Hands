package com.example.disastersafetyapp.models;

public class Info {
    String name,desc;
    String img_url;

    public Info() {
    }

    public Info(String name, String desc, String img_url) {
        this.name = name;
        this.desc = desc;
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
