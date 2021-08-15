package com.example.homehealthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DietStore extends AppCompatActivity {
    private ListView listView;
    private int apple=0;
    private int chia=0;
    private int coffee=0;
    private int egg=0;
    private Intent intent;
    Button appleCiderAddtoCart;
    Button chiaSeedAddToCart;
    Button appleCiderRemoveCart;
    Button chiaSeedRemoveCart;
    TextView appleCiderAmountInTextView;
    FloatingActionButton checkOutButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_store);

        appleCiderAddtoCart = (Button) findViewById(R.id.appleciderIncrement);
        appleCiderAmountInTextView = (TextView) findViewById(R.id.appleciderAdded);
        chiaSeedAddToCart = (Button) findViewById(R.id.chiaSeedIncrement);
        appleCiderRemoveCart = (Button) findViewById(R.id.appleciderDecrement);
        chiaSeedRemoveCart = (Button) findViewById(R.id.chiaSeedDecrement);
        checkOutButton = (FloatingActionButton) findViewById(R.id.checkOut);



        appleCiderAddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apple++;
                appleCiderAmountInTextView.setText("" +apple);
            }

        });
        appleCiderRemoveCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(apple!=0)
                {
                    apple--;
                    appleCiderAmountInTextView.setText("" +apple);
                }
                else
                {
                    Toast.makeText(DietStore.this,"You did not add any apple cider yet",Toast.LENGTH_LONG).show();
                }
            }
        });

        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DietStore.this,"You are buying "+apple+" Apples",Toast.LENGTH_LONG).show();
            }
        });



    }
}