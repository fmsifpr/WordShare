package com.example.felipemiranda.notnote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Login(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
    public void Cadastrar(View view) {
        Intent intent = new Intent(this, Cadastro.class);
        startActivity(intent);
    }
    public void Sobre(View view) {
        Intent intent = new Intent(this, Sobre.class);
        startActivity(intent);
    }
}
