package com.example.ReviewService.Service.Dto;

public class ReviewDto {
    private int     rating;
    private String  customerName;
    private String  description;

    public ReviewDto(int rating, String customerName, String description) {
        this.rating = rating;
        this.customerName = customerName;
        this.description = description;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
