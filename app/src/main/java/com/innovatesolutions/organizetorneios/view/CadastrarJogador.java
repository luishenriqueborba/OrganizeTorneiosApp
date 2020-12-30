package com.innovatesolutions.organizetorneios.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.adapter.EquipesAdapter;
import com.innovatesolutions.organizetorneios.api.AppUtil;
import com.innovatesolutions.organizetorneios.controller.EquipeController;
import com.innovatesolutions.organizetorneios.controller.JogadorController;
import com.innovatesolutions.organizetorneios.model.Equipe;
import com.innovatesolutions.organizetorneios.model.Jogador;

import java.util.ArrayList;

public class CadastrarJogador extends AppCompatActivity {

    SharedPreferences preferences;

    Jogador jogador;

    Equipe equipe, equipeSelecionada;

    EquipeController equipeController;

    EquipesAdapter adapter;

    JogadorController jogadorController;

    Spinner spinnerEquipes;

    EditText editNome, editNumero, editGols, editCartoesAmarelos, editCartoesVermelhos;

    Button btnCadastrarJogador;

    ArrayList<Equipe> listaEquipes;

    int ultimoID, equipeID, qtdJogadores, idEquipeSelecionada;

    String telaAnterior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_jogador);

        restaurarSharedPreferences();

        popularSpinner();

        initFormulario();
    }

    private void initFormulario() {

        spinnerEquipes = findViewById(R.id.SpinnerEquipes);
        editNome = findViewById(R.id.editNome);
        editNumero = findViewById(R.id.editNumero);
        editGols = findViewById(R.id.editGols);
        editCartoesAmarelos = findViewById(R.id.editCartaoAmarelo);
        editCartoesVermelhos = findViewById(R.id.editCartaoVermelho);
        btnCadastrarJogador = findViewById(R.id.btnCadastrarJogador);

        equipeController = new EquipeController(getApplicationContext());

        listaEquipes = equipeController.listarTodasEquipes();

        adapter = new EquipesAdapter(getApplicationContext(), listaEquipes);

        spinnerEquipes.setAdapter(adapter);

    }

    private boolean validarFormulario() {

        boolean retorno = true;

        if (TextUtils.isEmpty(editNome.getText().toString())) {
            editNome.setError("*");
            editNome.requestFocus();
            retorno = false;
        }

        if (TextUtils.isEmpty(editNumero.getText().toString())) {
            editNumero.setError("*");
            editNumero.requestFocus();
            retorno = false;
        }

        if (TextUtils.isEmpty(editGols.getText().toString())) {
            editGols.setError("*");
            editGols.requestFocus();
            retorno = false;
        }

        if (TextUtils.isEmpty(editCartoesAmarelos.getText().toString())) {
            editCartoesAmarelos.setError("*");
            editCartoesAmarelos.requestFocus();
            retorno = false;
        }

        if (TextUtils.isEmpty(editCartoesVermelhos.getText().toString())) {
            editCartoesVermelhos.setError("*");
            editCartoesVermelhos.requestFocus();
            retorno = false;
        }

        return retorno;
    }

    public void voltar(View view) {

        Intent intent = new Intent(CadastrarJogador.this, Dashboard.class);
        startActivity(intent);
        finish();
        return;
    }

    @Override
    public void onBackPressed() {
        limparTelaAnterior();
        Intent intent = new Intent(this, Dashboard.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;
    }

    public void cadastrarJogador(View view) {

        if (validarFormulario()) {

            equipeSelecionada = new Equipe();
            equipeSelecionada = (Equipe) spinnerEquipes.getSelectedItem();
            idEquipeSelecionada = equipeSelecionada.getId();

            jogador = new Jogador();
            jogadorController = new JogadorController(getApplicationContext());

            jogador.setEquipeId(idEquipeSelecionada);
            jogador.setNome(editNome.getText().toString());
            jogador.setNumero(editNumero.getText().toString());
            jogador.setGols(Integer.parseInt(editGols.getText().toString()));
            jogador.setCartaoAmarelo(Integer.parseInt(editCartoesAmarelos.getText().toString()));
            jogador.setCartaoVermelho(Integer.parseInt(editCartoesVermelhos.getText().toString()));

            if (jogadorController.incluir(jogador)) {

                ultimoID = jogadorController.getUltimoID();

                qtdJogadores += +1;

                salvarSharedPreferences();

                Toast.makeText(this, "Cadastro concluído!", Toast.LENGTH_SHORT).show();

                if (!telaAnterior.isEmpty()) {
                    if (telaAnterior == "artilharia") {
                        Intent intent = new Intent(CadastrarJogador.this, Artilharia.class);
                        startActivity(intent);
                        finish();
                        return;
                    } else {
                        Intent intent = new Intent(CadastrarJogador.this, Cartoes.class);
                        startActivity(intent);
                        finish();
                        return;
                    }
                }
            } else {

                Toast.makeText(this, "Não foi possível concluir o adastro!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(CadastrarJogador.this, Artilharia.class);
                startActivity(intent);
                finish();
                return;
            }

        } else
            Toast.makeText(this, "Favor, preencher todos os campos!", Toast.LENGTH_SHORT).show();
    }

    public void popularSpinner() {

        listaEquipes = new ArrayList<>();
        listaEquipes.add(new Equipe());
    }

    private void limparTelaAnterior() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putString("telaAnterior", "");
        dados.apply();
    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        qtdJogadores = preferences.getInt("qtdJogadores", -1);
        telaAnterior = preferences.getString("telaAnterior", "");

    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("qtdJogadores", qtdJogadores);
        dados.apply();

    }
}