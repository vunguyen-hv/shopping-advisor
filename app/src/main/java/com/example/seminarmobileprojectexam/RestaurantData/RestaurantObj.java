package com.example.seminarmobileprojectexam.RestaurantData;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "restaurant_table")
public class RestaurantObj implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String placeName;
    @ColumnInfo(name = "address")
    private String address;
    @ColumnInfo(name = "website")
    private String website;
    @ColumnInfo(name = "image")
    private String image;
    @ColumnInfo(name = "start_hour")
    private String startTime;
    @ColumnInfo(name = "end_hour")
    private String endTime;
    @ColumnInfo(name = "start_index")
    private int startIndex;
    @ColumnInfo(name = "end_index")
    private int endIndex;
    @ColumnInfo(name = "phone")
    private String phone;

    public RestaurantObj(String placeName, String address, String website, String image, String startTime, String endTime, int startIndex, int endIndex, String phone) {
        this.placeName = placeName;
        this.address = address;
        this.website = website;
        this.image = image;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}