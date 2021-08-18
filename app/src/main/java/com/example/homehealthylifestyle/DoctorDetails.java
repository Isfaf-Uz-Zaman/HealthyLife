package com.example.homehealthylifestyle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DoctorDetails extends AppCompatActivity {
    ImageView imageView;
    TextView textView, textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        imageView = (ImageView) findViewById(R.id.profile_pic);
        textView = (TextView) findViewById(R.id.personName);
        textView2 = (TextView) findViewById(R.id.lastMessage);

    }
}