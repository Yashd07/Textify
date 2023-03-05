package com.example.textify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);

        splashScreenLauncher splash = new splashScreenLauncher();
        splash.start();

    }

    private class splashScreenLauncher extends Thread{
        public void run(){
            try{
                int splash_time = 3;
                sleep(1000 * splash_time);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            Intent intent = new Intent(SplashscreenActivity.this,MainActivity.class);
            startActivity(intent);
            SplashscreenActivity.this.finish();
        }
    }
}