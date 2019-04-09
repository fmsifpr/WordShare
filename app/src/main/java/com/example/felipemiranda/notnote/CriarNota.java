package com.example.felipemiranda.notnote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import DBController.ConectaBD;

public class CriarNota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_nota);
    }
    public void criarNota(View V) throws IOException {

        EditText tituloEditText = (EditText) findViewById(R.id.nota_titulo);
        String titulo = tituloEditText.getText().toString();

        EditText subtituloEditText = (EditText) findViewById(R.id.nota_subtitulo);
        String subtitulo = subtituloEditText.getText().toString();

        EditText conteudoEditText = (EditText) findViewById(R.id.nota_conteudo);
        String conteudo = conteudoEditText.getText().toString();

        int notaFeito = ConectaBD.insertNota(getApplicationContext(), titulo, subtitulo, conteudo);

        if (notaFeito == 1) {

            Toast.makeText(getApplicationContext(),"Nota Salva com Sucesso", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getApplicationContext(),"Nota Não Realizada", Toast.LENGTH_SHORT).show();
        }
    }
}
}
