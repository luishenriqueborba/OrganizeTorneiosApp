package com.innovatesolutions.organizetorneios.view;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;

public class Splash extends AppCompatActivity {

    private boolean isRememberPassword = false;
    private ImageView imgLogo;
    private ImageView imgInnovate;
    private TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        imgLogo = findViewById(R.id.imgLogoSplash);
        txtTitle = findViewById(R.id.txtTitleSplash);
        imgInnovate = findViewById(R.id.imgInnovate);

        loadAnimation();
        restoreSharedPreferences();
        initApp();
    }

    private void loadAnimation() {
        Animation topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        Animation bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        String folder = "fonts/";
        String fontBanger = "Bangers.ttf";
        Typeface font = Typeface.createFromAsset(getAssets(), folder + fontBanger);
        txtTitle.setTypeface(font);

        imgLogo.setAnimation(topAnim);
        txtTitle.setAnimation(bottomAnim);
        imgInnovate.setAnimation(bottomAnim);
    }

    private void initApp() {
        new Handler().postDelayed(() -> {
            if (isRememberPassword) {
                AppUtil.goNextScreen(Splash.this, EscolherTorneio.class, true);
            } else {
                AppUtil.goNextScreen(Splash.this, Login.class, true);
            }
            finish();
        }, AppUtil.TIME_SPLASH);
    }

    private void restoreSharedPreferences() {
        SharedPreferences preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        isRememberPassword = preferences.getBoolean("loginAutomatico", false);
    }

}