package com.example.seminarmobileprojectexam;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Restaurant_detail extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_detail);
    }

    private void populateListClothes() {
        ListView listView = (ListView) findViewById(R.id.listFood);
//        ClothesViewModel clothesViewModel = new ClothesViewModel();
        ArrayList<DataItem> dataItems = new ArrayList<>();
        // add them data vao day

        ItemAdapter itemAdapter = new ItemAdapter(this, dataItems);
        listView.setAdapter(itemAdapter);
    }

    public void findRoute(View view) {

    }

    public void makeCall(View view) {
        String phoneNumber = ((TextView)view).getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
