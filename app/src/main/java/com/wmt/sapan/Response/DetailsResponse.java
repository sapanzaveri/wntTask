package com.wmt.sapan.Response;

public class DetailsResponse {
    Picture picture;
    Name name;
    String email;
    DOB dob;

    public DetailsResponse(Picture picture, Name name, String email, DOB dob) {
        this.picture = picture;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DOB getDob() {
        return dob;
    }

    public void setDob(DOB dob) {
        this.dob = dob;
    }
}
