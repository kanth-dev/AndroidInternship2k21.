package com.example.example_reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import static android.content.Intent.ACTION_POWER_CONNECTED;

public class MyReceiver extends BroadcastReceiver {
    ImageView iv;

    public MyReceiver(ImageView iv) {
        this.iv = iv;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        
        switch (intent.getAction()) {
            case ACTION_POWER_CONNECTED:
                iv.setImageResource(R.drawable.ic_present);
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                iv.setImageResource(R.drawable.ic_charge);
                break;

        }
    }



    }
