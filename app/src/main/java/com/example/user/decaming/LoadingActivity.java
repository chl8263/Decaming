package com.example.user.decaming;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by User on 2017-05-13.
 */


public class LoadingActivity extends AppCompatActivity {
    private Animation anim_one;
    private Animation anim_two;
    private Animation anim_three;
    private Animation anim_four;
    private TextView loading_text [] = new  TextView[4];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        //imageView = (ImageView)findViewById(R.id.img);
        startLoading();
        //anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.load_anim);
        //imageView.startAnimation(anim);
        loading_text[0] = (TextView)findViewById(R.id.loading_circle_one);
        loading_text[1] = (TextView)findViewById(R.id.loading_circle_two);
        loading_text[2] = (TextView)findViewById(R.id.loading_circle_three);
        loading_text[3] = (TextView)findViewById(R.id.loading_circle_four);

        anim_one = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.load_anim);
        anim_two = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.load_anim_two);
        anim_three = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.load_anim_three);
        anim_four = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.load_anim_four);

        loading_text[0].startAnimation(anim_one);
        loading_text[1].startAnimation(anim_two);
        loading_text[2].startAnimation(anim_three);
        loading_text[3].startAnimation(anim_four);
    }
    private void startLoading(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoadingActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },1500);

    }
}
