package com.example.myapplication.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "indeces")
public class Indeces {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;
    private double BMI;
    private double Ponderal;
    private double Broca;
    private double BSI;
    private double AMI;
    private double WHTR;
    private double WHR;
    private double BodyFat;

    public Indeces(double BMI, double Ponderal, double Broca, double BSI, double AMI, double WHTR, double WHR, double BodyFat) {
        this.BMI = BMI;
        this.Ponderal = Ponderal;
        this.Broca = Broca;
        this.BSI = BSI;
        this.AMI = AMI;
        this.WHTR = WHTR;
        this.WHR = WHR;
        this.BodyFat = BodyFat;
    }

    public double getBMI() {
        return BMI;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public double getPonderal() {
        return Ponderal;
    }

    public void setPonderal(double Ponderal) {
        this.Ponderal = Ponderal;
    }

    public double getBroca() {
        return Broca;
    }

    public void setBroca(double Broca) {
        this.Broca = Broca;
    }

    public double getBSI() {
        return BSI;
    }

    public void setBSI(double BSI) {
        this.BSI = BSI;
    }

    public double getAMI() {
        return AMI;
    }

    public void setAMI(double AMI) {
        this.AMI = AMI;
    }

    public double getWHTR() {
        return WHTR;
    }

    public void setWHTR(double WHTR) {
        this.WHTR = WHTR;
    }

    public double getWHR() {
        return WHR;
    }

    public void setWHR(double WHR) {
        this.WHR = WHR;
    }

    public double getBodyFat() {
        return BodyFat;
    }

    public void setBodyFat(double BodyFat) {
        this.BodyFat = BodyFat;
    }
}
