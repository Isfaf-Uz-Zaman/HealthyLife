package com.example.homehealthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DeliveryDetrails extends AppCompatActivity {

    private TextView customerName;
    private EditText customerAddress;
    private EditText customerPhone;
    private Button orderDone;
    public String youHaveOrdered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_detrails);

        customerName = (TextView) findViewById(R.id.customerNameID);
        customerAddress = (EditText) findViewById(R.id.customerAddressID);
        customerPhone = (EditText) findViewById(R.id.customerPhoneID);
        orderDone = (Button) findViewById(R.id.cutomerOrderDoneButtonID);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            youHaveOrdered = bundle.getString("Order");
        }


        orderDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData();

            }


        });


    }


    /*
    *This method is used to store data in firebase
    *
    * */


    private void SaveData() {

        String name = customerName.getText().toString().trim();
        String address = customerAddress.getText().toString().trim();
        String phone = customerPhone.getText().toString().trim();


    }
}