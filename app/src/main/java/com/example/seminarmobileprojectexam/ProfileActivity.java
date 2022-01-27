package com.example.seminarmobileprojectexam;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.seminarmobileprojectexam.API.client.APIService;
import com.example.seminarmobileprojectexam.API.model.updateAuth;
import com.example.seminarmobileprojectexam.User.User;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    private TextView optionView, nameView, emailView, backView;
    private EditText username, oldPassword, newPassword, rePassword;
    private TextView saveOption, cancelOption;
    private User user = null;
    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mAPIService = APIUtils.getAPIService();

        showProfileInfo();
    }

    private void showProfileInfo() {
        setContentView(R.layout.activity_profile);
        getUserFromActivity();
        viewIntoLayout();
        setEditOption();
        statusBarColor();
    }

    private void viewIntoLayout() {
        nameView = (TextView) findViewById(R.id.usernameProfile);
        emailView = (TextView) findViewById(R.id.emailProfile);
        nameView.setText(user.getUsername());
        emailView.setText(user.getEmail());

    }

    private void getUserFromActivity() {
        if (user == null){
            user = (User) getIntent().getSerializableExtra("user");
        }
    }

    private void setEditOption() {
        optionView = (TextView) findViewById(R.id.editOption);
        backView = (TextView) findViewById(R.id.backHome);
        optionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeIntoEditFrofile();
            }
        });
        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }

    private void changeIntoEditFrofile() {
        setContentView(R.layout.activity_edit_profile);
        prepareView();
        setOptionButton();
    }

    private void setOptionButton() {
        saveOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPassword();
            }
        });
        cancelOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProfileInfo();
            }
        });
    }

    private void prepareView() {
        username = (TextInputEditText) findViewById(R.id.usernameEditProfile);
        oldPassword = (TextInputEditText) findViewById(R.id.oldpasswordEditProfile);
        newPassword = (TextInputEditText) findViewById(R.id.newpasswordEditProfile);
        rePassword = (TextInputEditText) findViewById(R.id.repasswordEditProfile);
        saveOption = (TextView) findViewById(R.id.saveOption);
        cancelOption = (TextView) findViewById(R.id.cancelOption);
    }

    private void checkPassword() {
        if (oldPassword.getText().toString().equals(user.getPassword().toString())) {
            if (!newPassword.getText().toString().equals(rePassword.getText().toString()))
                Toast.makeText(this, "Re-type password is different", Toast.LENGTH_LONG).show();
            else {
                updatePassword(user.getEmail(), newPassword.getText().toString());
                showProfileInfo();
            }
        } else {
            Toast.makeText(this, "Wrong old Password", Toast.LENGTH_LONG).show();
        }
    }

    private void updatePassword(String email, String newPassword) {
        mAPIService.update(email, newPassword, user.getToken()).enqueue(new Callback<updateAuth>() {
            @Override
            public void onResponse(Call<updateAuth> call, Response<updateAuth> response) {
                if (response.isSuccessful()){
                    user = new User(response.body().getEmail(), response.body().getUsername(), response.body().getPassword(), response.body().getAvatarUrl(), response.body().getToken());
                }
                else {
                    int status = response.code();
                    if (status==401){
                        Toast.makeText(getApplicationContext(), "Something went wrong",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<updateAuth> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Request timeout",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void statusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.main_green, this.getTheme()));
        }
    }
}
