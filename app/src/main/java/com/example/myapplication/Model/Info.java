package com.example.myapplication.Model;

public class Info {
    private String mTitle;
    private String mParagraph;

    public Info(String title, String paragraph){
        mTitle =  title;
        mParagraph = paragraph;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getParagraph() {
        return mParagraph;
    }
}
