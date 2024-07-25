package com.example.intentactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DataShowActivity extends AppCompatActivity {

    TextView txtEmail, txtPassword, txtGender, txtLanguage;
    Button btnGotoDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_show);

        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        txtGender = findViewById(R.id.txtGender);
        txtLanguage = findViewById(R.id.txtLanguage);

        btnGotoDetail = findViewById(R.id.btnGotoDetail);

        Intent intent = getIntent();

        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        String gender = intent.getStringExtra("gender");
        String language[] = intent.getStringArrayExtra("language");

        txtEmail.setText(email);
        txtPassword.setText(password);
        txtGender.setText(gender);
        txtLanguage.setText(language[0] + "," + language[1] + "," + language[2]);

        btnGotoDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}