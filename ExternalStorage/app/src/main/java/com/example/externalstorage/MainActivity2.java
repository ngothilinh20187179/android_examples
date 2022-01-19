package com.example.externalstorage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        detail = findViewById(R.id.detail);
        Intent intent = getIntent();
        detail.setText(intent.getStringExtra("detail"));
    }
}