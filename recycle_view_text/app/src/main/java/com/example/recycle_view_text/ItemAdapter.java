package com.example.recycle_view_text;

public class ItemAdapter {
    private int image;
    private String name,price;
    public int getImage(){
        return image;
    }
    public void setImage(int image) {
        this.image = image;

    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setPrice(String price){
        this.price=price;
    }
    public String getPrice(){
        return price;
    }

}
