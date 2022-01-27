package com.example.seminarmobileprojectexam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.seminarmobileprojectexam.RestaurantData.RestaurantObj;
import com.example.seminarmobileprojectexam.RestaurantData.RestaurantViewModel;

public class Res_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            int Id = bundle.getInt("ID");
            RestaurantViewModel restaurantViewModel = new ViewModelProvider(this).get(RestaurantViewModel.class);
            RestaurantObj restaurantObj = restaurantViewModel.findById(Id);
            prepareContent(restaurantObj);
        }
    }

    private void prepareContent(RestaurantObj restaurantObj) {
        ImageView imageView = findViewById(R.id.supermarketImage);
        int resId = imageView.getContext().getResources().getIdentifier(restaurantObj.getImage(), "drawable", imageView.getContext().getPackageName());
        imageView.setImageResource(resId);
        TextView textViewAdd = findViewById(R.id.address);
        textViewAdd.setText(restaurantObj.getAddress());
        TextView textViewTime = findViewById(R.id.available_time);
        textViewTime.setText(restaurantObj.getStartTime() + " - " + restaurantObj.getEndTime());

        TextView contact = findViewById(R.id.phone_numbers);
        contact.setText(restaurantObj.getPhone());

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