package com.example.marenjifo.cliente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Cuenta extends AppCompatActivity {

    private TextView tv_saludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);

        Intent intent = getIntent();
        String usua = intent.getStringExtra("usuario");
        tv_saludo=findViewById(R.id.tv_saludo);
        tv_saludo.setText("Hola"+usua);

    }
}
