package com.example.seminarmobileprojectexam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.seminarmobileprojectexam.CinemaData.CinemaObj;
import com.example.seminarmobileprojectexam.CinemaData.CinemaViewModel;
import com.example.seminarmobileprojectexam.Map.MapsActivity;

public class Cine_detail extends AppCompatActivity {
    private CinemaObj cinemaObj = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cine_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            int Id = bundle.getInt("ID");
            CinemaViewModel cinemaViewModel = new ViewModelProvider(this).get(CinemaViewModel.class);
            cinemaObj = cinemaViewModel.findById(Id);
            prepareContent(cinemaObj);
        }

        TextView direction = findViewById(R.id.direction);
        direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cinemaObj != null) {
                    Intent intent = new Intent(view.getContext(), MapsActivity.class);
                    intent.putExtra("address", cinemaObj.getAddress());
                    startActivity(intent);
                }
            }
        });



    };


    private void prepareContent(CinemaObj cinemaObj) {
        ImageView imageView = findViewById(R.id.cinemaImage);
        int resId = imageView.getContext().getResources().getIdentifier(cinemaObj.getImage(), "drawable", imageView.getContext().getPackageName());
        imageView.setImageResource(resId);
        TextView textViewAdd = findViewById(R.id.address);
        textViewAdd.setText(cinemaObj.getAddress());
        TextView textViewTime = findViewById(R.id.available_time);
        textViewTime.setText(cinemaObj.getStartTime() + " - " + cinemaObj.getEndTime());

        TextView contact = findViewById(R.id.phone_numbers);
        contact.setText(cinemaObj.getPhone());
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