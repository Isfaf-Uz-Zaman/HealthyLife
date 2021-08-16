package com.example.homehealthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CheckoutPage extends AppCompatActivity {

    private TextView orderConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_page);

        orderConfirm =(TextView)findViewById(R.id.selectedProductsTextViewID);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            String userPurchasedAppleCider = bundle.getString("APPLE");
            String userPurchasedChiaSeed = bundle.getString("CHIA");
            String userPurchasedCoffee = bundle.getString("COFFEE");
            String userPurchasedEgg = bundle.getString("EGG");


            orderConfirm.setText("You have selected\nApple Cider" +userPurchasedAppleCider+ "\nChia seed" +userPurchasedAppleCider+ "\nCoffee" +userPurchasedCoffee+ "\nEgg" +userPurchasedEgg);
        }


    }
}