package com.example.servletytpo;

import java.util.Date;

public class Car {
    public String brand;
    public String model;
    public String type;
    public int fuelConsumption;
    public int year;

    public Car(String brand, String model, String type, int fuelConsumption, int year) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.fuelConsumption = fuelConsumption;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
