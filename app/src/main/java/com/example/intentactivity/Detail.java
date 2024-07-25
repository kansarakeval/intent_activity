package com.example.intentactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class Detail extends AppCompatActivity {

    EditText edtEmail, edtPassword;
    Button btnSubmit;
    TextInputLayout textInputLayoutEmail, textInputLayoutPassword;

    RadioGroup radioGroupGender;
    RadioButton radioButton;

    CheckBox chkEnglish, chkHindi, chkGujarati;

    String english, hindi, gujarati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnSubmit = findViewById(R.id.btnSubmit);
        textInputLayoutEmail = findViewById(R.id.TxtInputLayoutEmail);
        textInputLayoutPassword = findViewById(R.id.TxtInputLayoutPassword);

        radioGroupGender = findViewById(R.id.radioGroupGender);

        chkEnglish = findViewById(R.id.chkEnglish);
        chkHindi = findViewById(R.id.chkHindi);
        chkGujarati = findViewById(R.id.chkGujarati);

        chkEnglish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    english = buttonView.getText().toString();
                } else {
                    english = null;
                }
            }
        });

        chkHindi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    hindi = buttonView.getText().toString();
                } else {
                    hindi = null;
                }
            }
        });

        chkGujarati.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    gujarati = buttonView.getText().toString();
                } else {
                    gujarati = null;
                }
            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int radioId = radioGroupGender.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

                if (edtEmail.length() == 0) {
                    textInputLayoutEmail.setError("Email is required");
                } else if (edtPassword.length() == 0) {
                    textInputLayoutPassword.setError("Password is required");
                } else if (edtPassword.length() <= 6) {
                    textInputLayoutPassword.setError("Password must be greater than 6 characters");
                } else if (radioId == -1) {
                    Toast.makeText(Detail.this, "Please select a gender", Toast.LENGTH_SHORT).show();
                } else {

                    String language[] = new String[3];
                    language[0] = english;
                    language[1] = hindi;
                    language[2] = gujarati;

                    textInputLayoutEmail.setError(null);
                    textInputLayoutPassword.setError(null);

                    Intent intent = new Intent(Detail.this, DataShowActivity.class);
                    intent.putExtra("email", edtEmail.getText().toString());
                    intent.putExtra("password", edtPassword.getText().toString());
                    intent.putExtra("gender", radioButton.getText().toString());
                    intent.putExtra("language", language);
                    startActivity(intent);

                   // Toast.makeText(Detail.this, "Email :" + edtEmail.getText().toString() + "\nPassword :" + edtPassword.getText().toString() + "\nGender :" + radioButton.getText().toString() + "\nLanguage :" + english + "," + hindi + "," + gujarati, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}