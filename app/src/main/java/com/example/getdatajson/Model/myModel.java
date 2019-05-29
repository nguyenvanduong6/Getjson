package com.example.getdatajson.Model;

public class myModel {
    private String name, description;

    public myModel() {
    }

    public myModel(String mName, String mDescription) {
        name = mName;
        description = mDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String mName) {
        name = mName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String mDescription) {
        description = mDescription;
    }
}
