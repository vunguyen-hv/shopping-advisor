package com.example.seminarmobileprojectexam;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<DataItem> {


    public ItemAdapter(@NonNull Context context, ArrayList<DataItem> dataItems) {
        super(context, 0, dataItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = createRow(position, parent);
        }
        return convertView;
    }

    private View createRow(int position, ViewGroup parent) {
        DataItem dataItem = this.getItem(position);
        View view = dataItem.createItemView(getContext());
        return view;
    }
}
