package com.example.homehealthylifestyle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class DeliveryDetrails extends AppCompatActivity{

    private TextView customerName;
    private EditText customerAddress;
    private EditText customerPhone;
    private Button orderDone;
    public String youHaveOrdered;
    FirebaseFirestore dataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_detrails);

        customerName = (TextView) findViewById(R.id.customerNameID);
        customerAddress = (EditText) findViewById(R.id.customerAddressID);
        customerPhone = (EditText) findViewById(R.id.customerPhoneID);
        orderDone = (Button) findViewById(R.id.cutomerOrderDoneButtonID);
        dataBase=FirebaseFirestore.getInstance();

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            youHaveOrdered = bundle.getString("Order");
        }


        orderDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();

            }



        });


    }


    /*
    *This method is used to store data in firebase
    *
    * */
    


    private void saveData() {

        String name = customerName.getText().toString().trim();
        String address = customerAddress.getText().toString().trim();
        String phone = customerPhone.getText().toString().trim();
        String order= youHaveOrdered;

        Map<String,String> items = new HashMap<>();
        items.put("Name",name);
        items.put("Address",address);
        items.put("Phone number",phone);
        items.put("Order Details",order);

        dataBase.collection("OrderDetails")
                .add(items)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(DeliveryDetrails.this,"Successful",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(DeliveryDetrails.this,ThankYouForOrdering.class);
                        startActivity(intent);

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(DeliveryDetrails.this,"Failed",Toast.LENGTH_LONG).show();
                    }
                });





    }
}