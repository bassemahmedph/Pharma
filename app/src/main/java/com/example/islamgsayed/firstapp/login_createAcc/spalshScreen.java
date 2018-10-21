package com.example.islamgsayed.firstapp.login_createAcc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.islamgsayed.firstapp.R;
import com.example.islamgsayed.firstapp.login_createAcc.loginActivity;

public class spalshScreen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.image1);
        ImageView imageView1 = findViewById(R.id.image2);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        imageView.startAnimation(animation);
        imageView1.startAnimation(animation);


        Thread timer = new Thread(){

            @Override
            public void run() {

                try {
                    sleep(5000);
                    Intent intent = new Intent(getApplicationContext(),loginActivity.class);
                    startActivity(intent);
                    finish();
                    super.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        };

        timer.start();
    }
}
