package com.example.seminarmobileprojectexam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.seminarmobileprojectexam.HospitalData.HospitalObj;
import com.example.seminarmobileprojectexam.HospitalData.HospitalViewModel;
import com.example.seminarmobileprojectexam.Map.MapsActivity;

public class Hos_Detail extends AppCompatActivity {
    HospitalObj hospitalObj =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hos_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            int Id = bundle.getInt("ID");
            HospitalViewModel hospitalViewModel = new ViewModelProvider(this).get(HospitalViewModel.class);
            hospitalObj = hospitalViewModel.findById(Id);
            prepareContent(hospitalObj);
        }

        TextView direction = findViewById(R.id.direction);
        direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hospitalObj != null) {
                    Intent intent = new Intent(view.getContext(), MapsActivity.class);
                    intent.putExtra("address", hospitalObj.getAddress());
                    startActivity(intent);
                }
            }
        });

    }
    private void prepareContent(HospitalObj hospitalObj){
        ImageView imageView = findViewById(R.id.supermarketImage);
        int resId = imageView.getContext().getResources().getIdentifier(hospitalObj.getImage(), "drawable", imageView.getContext().getPackageName());
        imageView.setImageResource(resId);

        TextView textViewAdd = findViewById(R.id.address);
        textViewAdd.setText(hospitalObj.getAddress());
        TextView textViewTime = findViewById(R.id.available_time);
        textViewTime.setText(hospitalObj.getStartTime() + " - " + hospitalObj.getEndTime());

        TextView contact = findViewById(R.id.phone_numbers);
        contact.setText(hospitalObj.getPhone());

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