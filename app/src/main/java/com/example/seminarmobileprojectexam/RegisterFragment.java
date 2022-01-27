package com.example.seminarmobileprojectexam;

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
import androidx.lifecycle.ViewModelProvider;

import com.example.seminarmobileprojectexam.API.client.APIService;
import com.example.seminarmobileprojectexam.API.client.APIUtils;
import com.example.seminarmobileprojectexam.API.model.registerAuth;
import com.example.seminarmobileprojectexam.User.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterFragment extends Fragment {


    public RegisterFragment() {
        // Required empty public constructor
    }
    private APIService mAPIService;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        mAPIService = APIUtils.getAPIService();
        Button buttonRegister = view.findViewById(R.id.btn_register);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etEmail = getEditText(view, R.id.et_email);
                String email = etEmail.getText().toString();

                EditText etPassword = getEditText(view, R.id.et_password);
                String password = etPassword.getText().toString();

                EditText etRepassword = getEditText(view, R.id.et_repassword);
                String rePassword = etRepassword.getText().toString();

                EditText etName = getEditText(view, R.id.et_name);
                String name = etName.getText().toString();

                boolean validInput = false;
                validInput = validateInput(email, etEmail);
                validInput = validateInput(password, etPassword) && validInput;
                validInput = validateInput(rePassword, etRepassword) && validInput;
                validInput = validateInput(name, etName) && validInput;

                if (validInput){
                    validateRegister(email, name, password);
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

    // create intent to switch to next activity
    private void switchToNextActivity() {
    }
    // get input from edit text
    private EditText getEditText(View view, int id) {
        EditText editText = (EditText) view.findViewById(id);
        return editText;
    }
    // validate user register information
    private void validateRegister(String email, String name, String password){
        mAPIService.register(email, name, password).enqueue(new Callback<registerAuth>() {
            @Override
            public void onResponse(Call<registerAuth> call, Response<registerAuth> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getContext(), "Swipe Right for Login",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getContext(), "Email exists", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<registerAuth> call, Throwable t) {
                Toast.makeText(getContext(), "Request timeout",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
