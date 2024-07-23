package com.example.intentactivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button button2;
    Button buttonSMS;
    Button buttonLink;
    Button buttonWebView;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn);
        button2 = findViewById(R.id.btnimplicit);
        buttonSMS = findViewById(R.id.butSMS);
        buttonLink = findViewById(R.id.btnLink);
        buttonWebView = findViewById(R.id.btnWebView);
        webView = findViewById(R.id.webView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Detail.class);
                startActivity(intent);
            }
        });

        // call
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+919558397529"));
                startActivity(intent);
            }
        });

        //SMS
        buttonSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:+919558397529"));
                intent.putExtra("sms_body", "Hello");
                intent.putExtra(Intent.EXTRA_TEXT, "Hello");
                startActivity(intent);
            }
        });

        //link Google
        buttonLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/"));
                startActivity(intent);
            }
        });

        buttonWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }
}