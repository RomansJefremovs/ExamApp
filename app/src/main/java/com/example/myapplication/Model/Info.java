package com.example.myapplication.Model;

public class Info {
    private String title;
    private String paragraph;

    public Info(){

    }
    public Info(String title, String paragraph) {
        this.title = title;
        this.paragraph = paragraph;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public String getTitle() {
        return title;
    }

    public String getParagraph() {
        return paragraph;
    }
}
