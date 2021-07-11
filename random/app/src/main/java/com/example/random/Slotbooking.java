package com.example.random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Slotbooking extends AppCompatActivity {

    GridLayout grids;





    int totalarea=0;
    TextView tw1,tab1,cost,multi;
   int areapriceperday = 10;
    int costperday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slotbooking);
        tab1=findViewById(R.id.tab);
        grids=findViewById(R.id.grid2);
        multi=findViewById(R.id.mul);
        cost=findViewById(R.id.cpd);




        tw1 = findViewById(R.id.tw1);
        tw1.setText("Your Area Is" + getIntent().getExtras().getString("str"));
        getSupportActionBar().hide();
        setToggleEvent(grids);







    }

    private void setToggleEvent(GridLayout grids) {
        for (int i=0; i<grids.getChildCount();i++){
            final CardView cardview= (CardView) grids.getChildAt(i);
            final int finalI=i;
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cardview.getCardBackgroundColor().getDefaultColor()==-1){
                        cardview.setCardBackgroundColor(Color.parseColor("#0000"));
                        areapriceperday -= costperday;
                        --totalarea;
                        Toast.makeText(Slotbooking.this,"you area is"+(finalI +1),Toast.LENGTH_SHORT).show();


                    }else {
                        cardview.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        areapriceperday +=costperday;
                        totalarea++;
                    }
                     tab1.setText(" your area is "+ totalarea);
                    cost.setText("Total cost is"+totalarea*10);







                }


            });
        }
    }


    public void click(View view) {
        String totalb = tab1.getText().toString().trim();
        String totalc = cost.getText().toString();
        Intent intent = new Intent(Slotbooking.this, payout.class);
        intent.putExtra("TotalArea", tab1.getText().toString());
        intent.putExtra("TotalCost", cost.getText().toString());

        startActivity(intent);
    }
}



