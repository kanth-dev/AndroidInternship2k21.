package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import static android.content.ContentValues.TAG;

public class payin extends AppCompatActivity  implements PaymentResultListener {
    TextView tvw,tat;
    EditText txt,txt1;
    Button ups,paid;
    Checkout checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payin);
        tvw=findViewById(R.id.tvs);
        ups=findViewById(R.id.up);
        tat=findViewById(R.id.totalc);
        txt=findViewById(R.id.days);
        txt1=findViewById(R.id.tvs1);
        Checkout.preload(getApplicationContext());
        paid=findViewById(R.id.paying);
        txt1.setText(getIntent().getExtras().getString("cost"));
        txt1.setKeyListener(null);
        txt1.setEnabled(false);
        ups.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Integer s =Integer.valueOf(txt.getText().toString()) * Integer.valueOf(txt1.getText().toString());
                tat.setText(s.toString());


            }
        });

        paid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount=tat.getText().toString();
                checkout=new Checkout();
                checkout.setKeyID("rzp_test_ts8O3XclgUfj5s");
                try {
                    JSONObject options=new JSONObject();
                    options.put("name", "Merchant Name");
                    options.put("description", "Reference No. #123456");
                    options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
                    options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
                    options.put("theme.color", "#3399cc");
                    options.put("currency", "INR");
                    options.put("amount", "50000");//pass amount in currency subunits
                    options.put("prefill.email", "gaurav.kumar@example.com");
                    options.put("prefill.contact","9988776655");
                    JSONObject retryObj = new JSONObject();
                    retryObj.put("enabled", true);
                    retryObj.put("max_count", 4);
                    options.put("retry", retryObj);

                    checkout.open(payin.this, options);

                } catch(Exception e) {
                    Log.e(TAG, "Error in starting Razorpay Checkout", e);
                }
            }


            });



                }

    @Override
    public void onPaymentSuccess(String s) {
        paid.setText("success"+s);
    }

    @Override
    public void onPaymentError(int i, String s) {
        paid.setText("failed"+s);

    };
            }






