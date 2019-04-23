package com.example.autism.sakil.autism;

public class CareCenterProfile {
    private String name;
    private String contact;
    private String email;
    private String address;
    private String about;



    public CareCenterProfile() {

    }
    public CareCenterProfile(String name,String contact,String email, String address, String about) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getAbout() {
        return about;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
