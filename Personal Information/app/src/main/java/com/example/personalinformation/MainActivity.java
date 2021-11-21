package com.example.personalinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    CheckBox agree;
    EditText name;
    EditText mssv;
    EditText dateOfBirth;
    EditText phone;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submit);
        agree = (CheckBox) findViewById(R.id.agree);
        name = (EditText) findViewById(R.id.name);
        mssv = (EditText) findViewById(R.id.mssv);
        dateOfBirth = (EditText) findViewById(R.id.dateOfBirth);
        phone = (EditText) findViewById(R.id.phone);
        email = (EditText) findViewById(R.id.email);
        submit.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                if(name.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                }
                else if(mssv.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter your mssv", Toast.LENGTH_SHORT).show();
                }
                else if(dateOfBirth.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter your date of birth", Toast.LENGTH_SHORT).show();
                }
                else if(phone.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter your phone", Toast.LENGTH_SHORT).show();
                }
                else if(email.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                }
                else if(agree.isChecked()){
                    Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "You need to agree to our terms", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}