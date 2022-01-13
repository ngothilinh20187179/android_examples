package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity2 extends AppCompatActivity {

    TextView userName;
    TextView name;
    TextView email2;
    TextView address;
    TextView company;
    TextView phone;
    ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        userName = findViewById(R.id.userName);
        name = findViewById(R.id.name);
        email2 = findViewById(R.id.email2);
        address = findViewById(R.id.address);
        company = findViewById(R.id.company);
        phone = findViewById(R.id.phone);
        photo = findViewById(R.id.imageView2);

        Intent intent = getIntent();

        String getName = intent.getStringExtra("name");
        String getUserName = intent.getStringExtra("userName");
        String getEmail = intent.getStringExtra("email");
        String getAddress = intent.getStringExtra("address");
        String getCompany = intent.getStringExtra("company");
        String getPhone = intent.getStringExtra("phone");
        String getAvatar = intent.getStringExtra("avatar");

        Picasso.get().load("https://lebavui.github.io" + getAvatar).into(photo);
        name.setText(getName);
        userName.setText(getUserName);
        email2.setText(getEmail);
        address.setText(getAddress);
        company.setText(getCompany);
        phone.setText(getPhone);

    }

}