package com.globalhiddenodds.tribe10androidjava.ui.adapters;

import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.globalhiddenodds.tribe10androidjava.data.History;
import com.globalhiddenodds.tribe10androidjava.ui.tools.Transform;

import java.util.List;

public class BindingAdapters {
    @BindingAdapter("setImageBitmap")
    public static void bindImage(ImageView imageView, Bitmap setImageBitmap) {
        imageView.setImageBitmap(setImageBitmap);
    }

    @BindingAdapter("data")
    public static void bindData(ImageView imageView, byte[] data) {
        Bitmap bitmap = Transform.getSingletonInstance().BytesToBitmap(data);
        imageView.setImageBitmap(bitmap);
    }

    @BindingAdapter("listData")
    public static void bindRecyclerView(RecyclerView recyclerView, List<History> listData) {
        PostAdapter adapter = (PostAdapter) recyclerView.getAdapter();
        assert adapter != null;
        adapter.submitList(listData);
    }
}
