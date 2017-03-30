package com.example.wellington.lolguide;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wellington.lolguide.view.ui.MainActivity;
import com.example.wellington.lolguide.view.ui.NoConnection;
import com.example.wellington.lolguide.view.ui.details.ChampionDetail;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashScreen extends AppCompatActivity {

    private int SPLASH_SCREEN_TIME = 1500;

    @Bind(R.id.ivLogoSplash)
    ImageView ivLogoSplash;
    @Bind(R.id.ivBackGroundSplash)
    ImageView ivBackgroundSplash;
    @Bind(R.id.tvRX)
    TextView tvRX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);

        showLogo();
        setRandomBackground();

        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/FrizQuadrata.ttf");
        tvRX.setTypeface(type);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                startMainActivity();
            }
        }, SPLASH_SCREEN_TIME);
    }


    public static List<Integer> getLoginImages() {
        List<Integer> imageList = new ArrayList<>();

        imageList.add(R.drawable.splash1);
        imageList.add(R.drawable.splash2);
        imageList.add(R.drawable.splash3);
        imageList.add(R.drawable.splash4);
        imageList.add(R.drawable.splash5);
        imageList.add(R.drawable.splash6);
        imageList.add(R.drawable.splash7);
        imageList.add(R.drawable.splash8);
        imageList.add(R.drawable.splash9);
        imageList.add(R.drawable.splash10);
        imageList.add(R.drawable.splash11);
        imageList.add(R.drawable.splash12);
        imageList.add(R.drawable.splash13);
        imageList.add(R.drawable.splash14);


        return imageList;
    }

    private void setRandomBackground() {
        List<Integer> imageList = getLoginImages();

        if (imageList != null && imageList.size() > 0) {
            Random random = new Random();
            int n = random.nextInt(imageList.size());

            Picasso.with(this).load(imageList.get(n)).into(ivBackgroundSplash);
        }
    }




    private void startMainActivity() {
        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void showLogo() {
        ivLogoSplash.setVisibility(View.VISIBLE);
    }

}
