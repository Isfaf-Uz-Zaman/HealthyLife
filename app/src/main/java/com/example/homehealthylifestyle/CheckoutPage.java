package com.example.homehealthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Model.DeliveryDetrails;

/**
 * This class represents the checkout page logic.
 *  @author Isfaf Uz Zaman,CSE327 project documentation
 */

public class CheckoutPage extends AppCompatActivity {
    /**
     * This will give a text view of customers order in checkout page order confirmation.
     */
    private TextView orderConfirm;
    /**
     * This button will let of customers  order confirmation if everything is ok.
     */
    private Button confirmButton;
    /**
     * This string will keep the data what customer ordered and pass it to next page.
     */
    private String totalOrder;
    /**
     * This method is used for making connection between front end and back end.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_page);

        orderConfirm =(TextView)findViewById(R.id.selectedProductsTextViewID);
        confirmButton =(Button) findViewById(R.id.confirmButtonID);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            String userPurchasedAppleCider = bundle.getString("APPLE");
            String userPurchasedChiaSeed = bundle.getString("CHIA");
            String userPurchasedCoffee = bundle.getString("COFFEE");
            String userPurchasedEgg = bundle.getString("EGG");
            String userTotalBill = bundle.getString("TOTAL");

            totalOrder = "You have selected\nApple Cider" +userPurchasedAppleCider+ "\nChia seed" +userPurchasedChiaSeed+ "\nCoffee" +userPurchasedCoffee+ "\nEgg" +userPurchasedEgg+ "\n\n\nTotal Bill = " +userTotalBill;


            orderConfirm.setText(totalOrder);
        }

        confirmButton.setOnClickListener(new View.OnClickListener() {
            /**
             * This button will work as transaction between checkout page to delivery details.
             */
            @Override

            public void onClick(View v) {
                Intent i = new Intent(CheckoutPage.this, DeliveryDetrails.class);
                i.putExtra("Order",totalOrder);
                startActivity(i);

            }
        });


    }
}