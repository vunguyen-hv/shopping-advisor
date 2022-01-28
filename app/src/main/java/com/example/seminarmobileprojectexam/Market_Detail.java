package com.example.seminarmobileprojectexam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.seminarmobileprojectexam.Map.MapsActivity;
import com.example.seminarmobileprojectexam.SupermarketData.ClothesViewModel;
import com.example.seminarmobileprojectexam.SupermarketData.MarketObj;
import com.example.seminarmobileprojectexam.SupermarketData.MarketViewModel;

import java.util.ArrayList;

public class Market_Detail extends AppCompatActivity {
    MarketObj marketObj =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            int Id = bundle.getInt("ID");
            MarketViewModel marketViewModel = new ViewModelProvider(this).get(MarketViewModel.class);
            marketObj = marketViewModel.findById(Id);
            populateListClothes(marketObj);
        }
        TextView direction = findViewById(R.id.direction);
        direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (marketObj != null) {
                    Intent intent = new Intent(view.getContext(), MapsActivity.class);
                    intent.putExtra("address", marketObj.getAddress());
                    startActivity(intent);
                }
            }
        });


    }

    private void populateListClothes(MarketObj marketObj) {
        ImageView imageView = findViewById(R.id.supermarketImage);
        int resId = imageView.getContext().getResources().getIdentifier(marketObj.getImage(), "drawable", imageView.getContext().getPackageName());
        imageView.setImageResource(resId);
        TextView textViewAdd = findViewById(R.id.address);
        textViewAdd.setText(marketObj.getAddress());
        TextView textViewTime = findViewById(R.id.available_time);
        textViewTime.setText(marketObj.getStartTime() + " - " + marketObj.getEndTime());

        TextView contact = findViewById(R.id.phone_numbers);
        contact.setText(marketObj.getPhone());

//        ListView listView = (ListView) findViewById(R.id.listClothes);
//        ClothesViewModel clothesViewModel = new ClothesViewModel(getApplication());
//        ArrayList<DataItem> dataItems = new ArrayList<>();
//
//        // add them data vao day
//
//        ItemAdapter itemAdapter = new ItemAdapter(this, dataItems);
//        listView.setAdapter(itemAdapter);
    }

    public void makeCall(View view) {
        String phoneNumber = ((TextView)view).getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void findRoute(View view) {

    }
}