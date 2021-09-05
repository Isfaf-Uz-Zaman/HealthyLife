package Model;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homehealthylifestyle.R;
import com.example.homehealthylifestyle.ThankYouForOrdering;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
/**
 * This class will take all the data provided by user in store and save it in firestore database.
 *  @author Isfaf Uz Zaman,CSE327 project documentation
 */
public class DeliveryDetrails extends AppCompatActivity{
    /**
     * This textview is used to get customer name
     */
    private TextView customerName;
    /**
     * This edit text is used to get customer address and phone number
     */
    private EditText customerAddress,customerPhone;
    /**
     * This button is used to get customer order confirmation
     */
    private Button orderDone;
    /**
     * This string is used to show customer what he ordered
     */
    public String youHaveOrdered;
    /**
     * This is used to connect the app in fire store.
     */
    FirebaseFirestore dataBase;

    /**
     * This method is used for making connection between front end and back end.
     */

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
            /**
             * When customer clicks on Order done it will redirect to database
             */
            @Override
            public void onClick(View v) {

                saveData();

            }



        });


    }


    /**
     * This method is used for taking all the data related to cutomer order and save directly to database.
     */
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
                    /**
                     * This will give a toast message when order is success.
                     */
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                        Toast.makeText(DeliveryDetrails.this,"Successful",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(DeliveryDetrails.this, ThankYouForOrdering.class);
                        startActivity(intent);

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    /**
                     * This will give a toast message when order is failed.
                     */
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(DeliveryDetrails.this,"Failed",Toast.LENGTH_LONG).show();
                    }
                });





    }
}