package com.example.desempenhoescolarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class erroGeral extends AppCompatActivity {
    private Button btVoltar = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erro_geral);

        btVoltar = (Button) findViewById(R.id.bta_voltar);

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(null, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}