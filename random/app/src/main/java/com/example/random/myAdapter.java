package com.example.random;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class myAdapter extends RecyclerView.Adapter<myAdapter.holder> {
    String data[];
    Context cntxt;

    public myAdapter(Context ct, String s1[]){
        cntxt =ct;
        data=s1;


    }
    @NonNull
    @NotNull
    @Override
    public holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(cntxt);
        View view=inflater.inflate(R.layout.singlerow,parent,false);


        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull holder holder, int position) {
        holder.tv.setText(data[position]);




    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv;
        ImageView img;

        public holder(@NonNull @NotNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.t1);
            img=itemView.findViewById(R.id.img1);
          itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Intent i=new Intent(cntxt,booking.class);
            i.putExtra("title", data);

            cntxt.startActivity(i);



        }
    }
}