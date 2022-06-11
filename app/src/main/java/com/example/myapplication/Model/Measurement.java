package com.example.myapplication.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "measurements")
public class Measurement {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private double weight;
    private double height;
    private double waist;
    private double hip;

    public Measurement(double weight, double height, double waist, double hip) {
        this.weight = weight;
        this.height = height;
        this.waist = waist;
        this.hip = hip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(float waist) {
        this.waist = waist;
    }

    public double getHip() {
        return hip;
    }

    public void setHip(float hip) {
        this.hip = hip;
    }
}
