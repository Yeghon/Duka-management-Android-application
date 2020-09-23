package com.android.myduka.utils;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import androidx.appcompat.app.AppCompatActivity;

import com.android.myduka.activity.MainActivity;

/**
 * @author yeghon on 12/13/19
 * @project Myduka
 */
public class MydukaBaseActivity extends AppCompatActivity {
/**
 * This class is responsible for timing out events based on user inactivity,
 * after a minute of inactivity, session time outs
 */


    public static final long DISCONNECT_TIMEOUT = 10000; // 60 sec = 60 * 1000 ms

    private Handler disconnectHandler = new Handler() {
        public void handleMessage(Message msg) {
        }
    };

    private Runnable disconnectCallback = new Runnable() {
        @Override
        public void run() {

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                    MydukaBaseActivity.this);
            alertDialog.setCancelable(false);
            alertDialog.setTitle("Alert");
            alertDialog
                    .setMessage("Session Timeout, Hit ok to go to previous screen.");
            alertDialog.setNegativeButton("OK",
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(MydukaBaseActivity.this,
                                    MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);

                            dialog.cancel();
                        }
                    });

            alertDialog.show();

            // Perform any required operation on disconnect
        }
    };

    public void resetDisconnectTimer() {
        disconnectHandler.removeCallbacks(disconnectCallback);
        disconnectHandler.postDelayed(disconnectCallback, DISCONNECT_TIMEOUT);
    }

    public void stopDisconnectTimer() {
        disconnectHandler.removeCallbacks(disconnectCallback);
    }

    @Override
    public void onUserInteraction() {
        resetDisconnectTimer();
    }

    @Override
    public void onResume() {
        super.onResume();
        resetDisconnectTimer();
    }

    @Override
    public void onStop() {
        super.onStop();
        stopDisconnectTimer();
    }
}