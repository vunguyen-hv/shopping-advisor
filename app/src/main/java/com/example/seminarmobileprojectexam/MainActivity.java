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

import com.example.seminarmobileprojectexam.User.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    private User user = null;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (user == null)
            user = (User) getIntent().getSerializableExtra("user");

        setupNavigateBot();
        statusBarColor();//set color AppBar
        toolbar = (Toolbar) findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);
        setupNavigate_left();

    }

    private void setupNavigateBot(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigate_menu);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.restaurant:
                        intent = new Intent(getApplicationContext(), Restaurant.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.cinema:
                        intent = new Intent(getApplicationContext(), Cinema.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.home:
                        return true;

                    case R.id.hospital:
                        intent = new Intent(getApplicationContext(), Hospital.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.supermarket:
                        intent = new Intent(getApplicationContext(), Supermarket.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
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
                        intent = new Intent(getApplicationContext(), ProfileActivity.class);
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