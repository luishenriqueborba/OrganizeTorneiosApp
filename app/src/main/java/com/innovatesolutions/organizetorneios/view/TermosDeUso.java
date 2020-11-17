package com.innovatesolutions.organizetorneios.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.innovatesolutions.organizetorneios.R;

public class TermosDeUso extends AppCompatActivity {

    TextView txtAceitacao, txtLicenca, txtAlteracoes, txtConsentimento, txtIsencao, mensagemAceitacao, mensagemLicenca, mensagemAlteracoes, mensagemConsentimento, mensagemIsencao;

    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termos_de_uso);

        init();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TermosDeUso.this, CadastrarUsuario.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                return;
            }
        });

    }

    private void init() {

        txtAceitacao = findViewById(R.id.txtAceitacao);
        txtLicenca = findViewById(R.id.txtLicenca);
        txtAlteracoes = findViewById(R.id.txtAlteracoes);
        txtConsentimento = findViewById(R.id.txtConsentimento);
        txtIsencao = findViewById(R.id.txtIsencao);
        mensagemAceitacao = findViewById(R.id.mensagemAceitacao);
        mensagemLicenca = findViewById(R.id.mensagemLicenca);
        mensagemAlteracoes = findViewById(R.id.mensagemAlteracoes);
        mensagemConsentimento = findViewById(R.id.mensagemConsentimento);
        mensagemIsencao = findViewById(R.id.mensagemIsencao);

        btnOk = findViewById(R.id.btnOK);
    }

    public void voltar(View view) {

        Intent intent = new Intent(TermosDeUso.this, CadastrarUsuario.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(TermosDeUso.this, CadastrarUsuario.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;
    }
}