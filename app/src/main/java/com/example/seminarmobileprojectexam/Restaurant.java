package com.example.seminarmobileprojectexam;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seminarmobileprojectexam.RestaurantData.RestaurantObj;
import com.example.seminarmobileprojectexam.RestaurantData.RestaurantViewModel;
import com.example.seminarmobileprojectexam.User.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Restaurant extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    private User user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (user == null)
            user = (User) getIntent().getSerializableExtra("user");

        setContentView(R.layout.activity_restaurant);
        statusBarColor();//set color AppBar
        toolbar = (Toolbar) findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);
        setupNavigateBot();
        setupNavigate_left();
        prepareContent();
    }

    private void prepareContent() {
        RestaurantViewModel restaurantViewModel = new ViewModelProvider(this).get(RestaurantViewModel.class);
        ArrayList<RestaurantObj> restaurantObj = (ArrayList<RestaurantObj>) restaurantViewModel.getAlls();
        recyclerView = (RecyclerView) findViewById(R.id.restaurantRecyclerView);
        RestaurantAdapter adapterRecycle = new RestaurantAdapter(this, restaurantObj);
        recyclerView.setAdapter(adapterRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setupNavigateBot() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigate_menu);
        bottomNavigationView.setSelectedItemId(R.id.restaurant);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.restaurant:
                        return true;

                    case R.id.cinema:
                        startActivity(new Intent(getApplicationContext(), Cinema.class).putExtra("user", user));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class).putExtra("user", user));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.hospital:
                        startActivity(new Intent(getApplicationContext(), Hospital.class).putExtra("user", user));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.supermarket:
                        startActivity(new Intent(getApplicationContext(), Supermarket.class).putExtra("user", user));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    private void setupNavigate_left() {
        navigationView = (NavigationView) findViewById(R.id.navigate_left);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Profile:
                        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        break;

                    case R.id.Logout:
                        Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.Favorite:
                        Toast.makeText(getApplicationContext(), "Favorite", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.Rate:
                        Toast.makeText(getApplicationContext(), "Rate", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                }
                return false;
            }
        });

    }

    private void statusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.main_green, this.getTheme()));
        }
    }
}
