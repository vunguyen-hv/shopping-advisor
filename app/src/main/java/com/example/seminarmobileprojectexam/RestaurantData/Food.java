package com.example.seminarmobileprojectexam.RestaurantData;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "food")
public class Food {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "image")
    private String foodImage;
    @ColumnInfo(name = "name")
    private String foodName;
    @ColumnInfo(name = "price")
    private long foodPrice;

    public Food(String foodImage, String foodName, long foodPrice) {
        this.foodImage = foodImage;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public long getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(long foodPrice) {
        this.foodPrice = foodPrice;
    }
}
