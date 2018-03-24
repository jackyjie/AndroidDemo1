package com.example.firstcodeandroid.Views.ListView;

/**
 * Created by JackR on 2018/3/22.
 */

public class Fruit {
    private String fruitName;
    private int imageId;

    public Fruit(String _fruitName, int _imageId){
        fruitName = _fruitName;
        imageId = _imageId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
