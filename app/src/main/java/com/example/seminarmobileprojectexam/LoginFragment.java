package com.example.seminarmobileprojectexam;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.seminarmobileprojectexam.API.client.APIService;
import com.example.seminarmobileprojectexam.API.client.APIUtils;
import com.example.seminarmobileprojectexam.API.model.loginAuth;
import com.example.seminarmobileprojectexam.User.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }
    private EditText etEmail;
    private EditText etPassword;
    private APIService mAPIService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        Button buttonLogin = view.findViewById(R.id.btn_login);
        mAPIService = APIUtils.getAPIService();
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etEmail = getEditText(view, R.id.et_email);
                etPassword = getEditText(view, R.id.et_password);

                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                boolean validInput = false;
                validInput = validateInput(email, etEmail);
                validInput = validateInput(password, etPassword) && validInput;

                if (validInput){
                    validateLogin(email, password);
                }
            }
        });
        return view;
    }

    private boolean validateInput(String text, EditText editText) {
        if (text.isEmpty()){
            ShapeDrawable shape = new ShapeDrawable(new RectShape());
            shape.getPaint().setColor(Color.RED);
            shape.getPaint().setStyle(Paint.Style.STROKE);
            shape.getPaint().setStrokeWidth(5);

            editText.setBackground(shape);
            Toast.makeText(getContext(), "Some field is empty",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private EditText getEditText(View view, int id) {
        EditText editText = (EditText) view.findViewById(id);
        return editText;
    }


    private void validateLogin(String email, String password) {
        mAPIService.login(email, password).enqueue(new Callback<loginAuth>() {
            @Override
            public void onResponse(Call<loginAuth> call, Response<loginAuth> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    User user = new User(response.body().getEmail(), response.body().getUsername(), response.body().getPassword(), response.body().getAvatarUrl(), response.body().getToken());
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                } else {
                    int status = response.code();
                    if (status == 401) {
                        Toast.makeText(getContext(), "Email or password are not correct", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<loginAuth> call, Throwable t) {
                Toast.makeText(getContext(), "Request timeout", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
