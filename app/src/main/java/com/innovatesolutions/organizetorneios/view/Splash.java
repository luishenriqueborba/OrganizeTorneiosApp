package com.innovatesolutions.organizetorneios.view;

import android.content.Intent;
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

    private boolean isLembrarSenha = false;

    Animation topAnim, bottomAnim;
    ImageView imgLogo, imgInnovate;
    TextView txtTitulo;
    String pasta = "fonts/";
    String fontBanger = "Bangers.ttf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        imgLogo = findViewById(R.id.imgLogoSplash);
        txtTitulo = findViewById(R.id.txtTituloSplash);
        imgInnovate = findViewById(R.id.imgInnovate);

        Typeface font = Typeface.createFromAsset(getAssets(), pasta + fontBanger);
        txtTitulo.setTypeface(font);

        imgLogo.setAnimation(topAnim);
        txtTitulo.setAnimation(bottomAnim);
        imgInnovate.setAnimation(bottomAnim);

        restaurarSharedPreferences();
        iniciarAplicativo();
    }

    private void iniciarAplicativo() {
        new Handler().postDelayed(() -> {
            if (isLembrarSenha) {
                AppUtil.goNextScreen(Splash.this, EscolherTorneio.class);
            } else {
                AppUtil.goNextScreen(Splash.this, Login.class);
            }
            finish();

        }, AppUtil.TIME_SPLASH);
    }

    private void restaurarSharedPreferences() {
        SharedPreferences preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        isLembrarSenha = preferences.getBoolean("loginAutomatico", false);
    }

}