package com.example.lab7.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.lab7.R;

public class SplashActivity extends AppCompatActivity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = findViewById(R.id.logo);

        if (logo != null) {
            // Load the correct star logo from Pinterest direct link
            Glide.with(this)
                    .load("https://i.pinimg.com/736x/7b/65/70/7b65700460aa810b17b90ac9440fca04.jpg")
                    .placeholder(R.mipmap.ic_launcher)
                    .into(logo);

            // Unique Motion: Pop, Spin, and Settle
            logo.setAlpha(0f);
            logo.setScaleX(0f);
            logo.setScaleY(0f);

            logo.animate()
                    .alpha(1f)
                    .scaleX(1.2f)
                    .scaleY(1.2f)
                    .rotation(720f)
                    .setDuration(2000)
                    .setInterpolator(new AccelerateDecelerateInterpolator())
                    .withEndAction(() -> {
                        logo.animate()
                                .scaleX(1f)
                                .scaleY(1f)
                                .setDuration(500)
                                .start();
                    })
                    .start();
        }

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, ListActivity.class));
            finish();
        }, 3500);
    }
}
