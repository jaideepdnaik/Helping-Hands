package com.example.disastersafetyapp.models;

public class User {
    String name,location,shelter,food,medical,finance,counselling,sanitation;
    public User() {

    }

    public User(String name, String location, String shelter, String food, String medical, String finance, String counselling, String sanitation) {
        this.name = name;
        this.location = location;
        this.shelter = shelter;
        this.food = food;
        this.medical = medical;
        this.finance = finance;
        this.counselling = counselling;
        this.sanitation = sanitation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getShelter() {
        return shelter;
    }

    public void setShelter(String shelter) {
        this.shelter = shelter;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }

    public String getFinance() {
        return finance;
    }

    public void setFinance(String finance) {
        this.finance = finance;
    }

    public String getCounselling() {
        return counselling;
    }

    public void setCounselling(String counselling) {
        this.counselling = counselling;
    }

    public String getSanitation() {
        return sanitation;
    }

    public void setSanitation(String sanitation) {
        this.sanitation = sanitation;
    }
}
