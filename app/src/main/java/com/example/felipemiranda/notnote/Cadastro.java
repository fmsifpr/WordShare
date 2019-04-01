package com.example.felipemiranda.notnote;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

import DBController.ConectaBD;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class Cadastro extends AppCompatActivity {

    private ConectaBD dbController = new ConectaBD();

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void cadastrar(View V) throws IOException {
        EditText nomeEditText = (EditText) findViewById(R.id.cadastro_nome);
        String nome = nomeEditText.getText().toString();

        EditText emailEditText = (EditText) findViewById(R.id.cadastro_email);
        String email = emailEditText.getText().toString();

        EditText senhaEditText = (EditText) findViewById(R.id.cadastro_senha);
        String senha = senhaEditText.getText().toString();

        int cadastroFeito = dbController.insertUsuarios(getApplicationContext(), nome, email, senha);

        if (cadastroFeito == 1) {
            criarAlertDialog("Cadastro realizado");
        } else {
            criarAlertDialog("Cadastro não realizado");
        }
    }

    public void criarAlertDialog(String mensagem) {

    }
}