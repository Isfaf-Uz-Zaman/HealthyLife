package com.example.homehealthylifestyle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This class is for Doctor Details <br/>
 * Just to find the image specialty and details from xml layout.
 * @author Md.Tansin Ullah Nabil, CSE327 Project Documentation <br/>
 */

public class DoctorDetails extends AppCompatActivity {
    ImageView imageView;
    TextView textView, textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        imageView = (ImageView) findViewById(R.id.profile_pic1);
        textView = (TextView) findViewById(R.id.personName1);
        textView2 = (TextView) findViewById(R.id.specialty1);

    }
}