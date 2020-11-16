package com.example.recycler;

public class Plant {
    private String name;
    private int imageId;
    private String function;
    public Plant(String name, int imageId, String function){
        this.name = name;
        this.imageId = imageId;
        this.function = function;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
    public String getFunction(){
        return function;
    }
}
