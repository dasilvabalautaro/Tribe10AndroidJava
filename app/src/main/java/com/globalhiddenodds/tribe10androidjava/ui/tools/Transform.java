package com.globalhiddenodds.tribe10androidjava.ui.tools;

import static java.lang.Math.max;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class Transform {
    private static Transform transform;

    private Transform(){}

    public static Transform getSingletonInstance() {
        if (transform == null) {
            transform = new Transform();
        }

        return transform;
    }

    public Bitmap resizeBitmap(Bitmap bitmap) {
        int newHeight = 1;
        int newWidth = 1;
        int maxSize = 512;

        if (max(bitmap.getHeight(), bitmap.getWidth()) > maxSize && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            double scaleFactor = ((double)bitmap.getWidth() / (double)bitmap.getHeight());
            newWidth = maxSize;
            newHeight = (int)((double)newWidth / scaleFactor);
        } else {
            newWidth = bitmap.getWidth();
            newHeight = bitmap.getHeight();
        }

        return Bitmap.createScaledBitmap(
                bitmap, newWidth, newHeight, true
        );
    }

    public byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
        return stream.toByteArray();
    }

    public Bitmap getBitmapFromDrawable(Context context, int drawable) {
        Drawable db = ContextCompat.getDrawable(context, drawable);

        assert db != null;
        Bitmap bit = Bitmap.createBitmap(
                db.getIntrinsicWidth(), db.getIntrinsicHeight(), Bitmap.Config.ARGB_8888
        );
        Canvas canvas = new Canvas(bit);

        db.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());

        db.draw(canvas);

        return bit;
    }

    public Bitmap BytesToBitmap(byte[] b) {
        if (b == null) {
            return null;
        }
        if (b.length != 0) {
            InputStream is = new ByteArrayInputStream(b);
            return BitmapFactory.decodeStream(is);
        } else {
            return null;
        }
    }
}
