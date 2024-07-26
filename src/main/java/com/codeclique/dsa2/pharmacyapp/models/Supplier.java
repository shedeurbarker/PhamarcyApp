package com.codeclique.dsa2.pharmacyapp.models;

public class Supplier {
    private String supplierID;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public Supplier(String supplierID, String name, String location, String contactInfo) {
        this.supplierID = supplierID;
        this.name = name;
        this.location = location;
        this.contactInfo = contactInfo;
    }

    private String location;
    private String contactInfo; // Optional

}
