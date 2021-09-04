package com.example.homehealthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
/**
 * This class represents diet store business logic.
 *  @author Isfaf Uz Zaman,CSE327 project documentation
 */
public class DietStore extends AppCompatActivity {
    /**
     * These variables  are used to count the users input in cart and generate the total bill and saves in another variable.
     */
    private int apple=0,chia=0,coffee=0,egg=0,totalBill=0;
    /**
     * These buttons are used to get inputs from user while they are in the shopping cart
     */
    Button appleCiderAddCart,appleCiderRemoveCart,chiaSeedAddToCart,chiaSeedRemoveCart,eggAddToCart,eggRemoveCart,coffeeAddToCart,coffeeRemoveCart;
    /**
     * These textview are used to set the value which the user added in each product
     */
    TextView appleCiderAmountInTextView,coffeeAmountInTextView,eggAmountInTextView,chiaSeedAmountInTextView;


    /**
     * This is a floating checkout button sitiing at the bottom in product page
     */
    FloatingActionButton checkOutButton;

    /**
     * This method is used for making connection between front end and back end.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_store);

        appleCiderAddCart = (Button) findViewById(R.id.appleciderIncrement);
        appleCiderRemoveCart = (Button) findViewById(R.id.appleciderDecrement);
        appleCiderAmountInTextView = (TextView) findViewById(R.id.appleciderAdded);


        chiaSeedAddToCart = (Button) findViewById(R.id.chiaSeedIncrement);
        chiaSeedRemoveCart = (Button) findViewById(R.id.chiaSeedDecrement);
        chiaSeedAmountInTextView= (TextView) findViewById(R.id.chiaSeedAdded);

        chiaSeedAddToCart = (Button) findViewById(R.id.chiaSeedIncrement);
        chiaSeedRemoveCart = (Button) findViewById(R.id.chiaSeedDecrement);
        chiaSeedAmountInTextView= (TextView) findViewById(R.id.chiaSeedAdded);

        eggAddToCart = (Button) findViewById(R.id.eggIncrement);
        eggRemoveCart = (Button) findViewById(R.id.eggDecrement);
        eggAmountInTextView= (TextView) findViewById(R.id.eggAdded);


        coffeeAddToCart = (Button) findViewById(R.id.coffeeIncrement);
        coffeeRemoveCart = (Button) findViewById(R.id.coffeeDecrement);
        coffeeAmountInTextView= (TextView) findViewById(R.id.coffeeAdded);

        checkOutButton = (FloatingActionButton) findViewById(R.id.checkOut);



        appleCiderAddCart.setOnClickListener(new View.OnClickListener() {
            /**
             * This is an onclick listener which will add one product every time user clicks add button and remove one after the user clicks remove button.
             */
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



        chiaSeedAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {
                chia++;
                chiaSeedAmountInTextView.setText("" +chia);
            }

        });
        chiaSeedRemoveCart.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(chia!=0)
                {
                    chia--;
                    chiaSeedAmountInTextView.setText("" +chia);
                }
                else
                {
                    Toast.makeText(DietStore.this,"You did not add any chia seed yet",Toast.LENGTH_LONG).show();
                }
            }
        });


        eggAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                egg++;
                eggAmountInTextView.setText("" +egg);
            }

        });
        eggRemoveCart.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(egg!=0)
                {
                    egg--;
                    eggAmountInTextView.setText("" +egg);
                }
                else
                {
                    Toast.makeText(DietStore.this,"You did not add egg yet",Toast.LENGTH_LONG).show();
                }
            }
        });

        coffeeAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                coffee++;
                coffeeAmountInTextView.setText("" +coffee);
            }

        });


        coffeeRemoveCart.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(coffee!=0)
                {
                    coffee--;
                    coffeeAmountInTextView.setText("" +coffee);
                }
                else
                {
                    Toast.makeText(DietStore.this,"You did not add any coffee yet",Toast.LENGTH_LONG).show();
                }
            }
        });




        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                totalBill = (apple*850)+(chia*180)+(egg*100)+(coffee*570);


                Intent intent = new Intent(DietStore.this,CheckoutPage.class);
                intent.putExtra("APPLE",""+apple);
                intent.putExtra("CHIA",""+chia);
                intent.putExtra("COFFEE",""+coffee);
                intent.putExtra("EGG",""+egg);
                intent.putExtra("TOTAL",""+totalBill);
                startActivity(intent);


            }
        });






    }

}