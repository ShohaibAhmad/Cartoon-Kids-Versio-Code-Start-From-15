package com.promoteprovider.cartoonkids;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.startapp.sdk.adsbase.StartAppAd;


public class SplashActivity extends AppCompatActivity {


    @Override
    @SuppressWarnings("DEPRECATION")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StartAppAd.disableSplash();
        Thread splashTread = new Thread(){


            @Override

            public void run() {

                try {

                    sleep(1500);

                    startActivity(new Intent(getApplicationContext(),MainActivity.class));

                    finish();

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }


                super.run();

            }

        };


        splashTread.start();





    }


}
