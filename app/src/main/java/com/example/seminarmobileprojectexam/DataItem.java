package com.example.seminarmobileprojectexam;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public abstract class DataItem implements Serializable {
    public abstract View createItemView(Context context);
    public void bindDataToTextView(String data, View view, int idTextView) {
        TextView textView = (TextView) view.findViewById(idTextView);
        textView.setText(data);
    }

    public void bindDataToImageView(View view, int iPhoneImageView, int resource) {
        ImageView imageView = (ImageView) view.findViewById(iPhoneImageView);
        imageView.setImageResource(resource);
    }
}
