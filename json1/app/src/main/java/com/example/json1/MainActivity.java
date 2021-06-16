package com.example.json1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText country;
    TextView dead,recov,con,act;
    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        country=findViewById(R.id.country);
        dead=findViewById(R.id.death);
        recov=findViewById(R.id.recover);
        con=findViewById(R.id.confirm);
        act=findViewById(R.id.active);
        pd=new ProgressDialog(this);
        pd.setMessage("Aagu ra mowa");
        pd.setProgress(ProgressDialog.STYLE_SPINNER);

    }

    public void search(View view) {
        String c =country.getText().toString().trim();
        pd.show();
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://api.covid19api.com/").addConverterFactory(ScalarsConverterFactory.create()).build();
        Class<? extends myinterface> response=retrofit.create(myinterface.class).getClass();
        response.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                String res = response.body();
                try {
                    JSONArray root = new JSONArray(res);
                    JSONObject obj = root.getJSONObject(root.length()-1);
                    String confirmed = obj.getString("Confirm");
                    String active = obj.getString("Active");
                    String recovered = obj.getString("Recovered");
                    String death = obj.getString("Deaths");

                    con.setText("Confirmed : "+confirmed);
                    act.setText("Active:"+active);

                    recov.setText("Recovered : "+recovered);
                    dead.setText("Death : "+death);
                    pd.dismiss();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(MainActivity.this, "failed",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
