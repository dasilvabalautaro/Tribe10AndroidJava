package com.globalhiddenodds.tribe10androidjava.ui.data;

import android.graphics.Bitmap;

import com.globalhiddenodds.tribe10androidjava.data.History;
import com.globalhiddenodds.tribe10androidjava.ui.tools.Transform;

public class EntryUiState {
    private String description;
    private Bitmap image;
    private boolean capture;

    public EntryUiState(String description, Bitmap image, boolean capture) {
        this.description = description;
        this.image = image;
        this.capture = capture;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public boolean isCapture() {
        return capture;
    }

    public void setCapture(boolean capture) {
        this.capture = capture;
    }

    public History toHistory() {
        byte[] byteImg = Transform.getSingletonInstance()
                .bitmapToByteArray(this.getImage());

        return new History(0, this.getDescription(), byteImg);
    }

}

