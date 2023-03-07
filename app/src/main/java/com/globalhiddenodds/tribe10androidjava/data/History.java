package com.globalhiddenodds.tribe10androidjava.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "histories")
public class History {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String description;

    private byte[] image;

    public History(int id, String description, byte[] image){
        this.setId(id);
        this.setDescription(description);
        this.setImage(image);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
