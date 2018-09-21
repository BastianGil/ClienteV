package com.example.marenjifo.cliente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Receptor.OnMessage {

    private Button btn_enviar;
    String cuenta;

    private EditText et_usu;
    private EditText et_con;
    private ImageView iv_imagen;
    String usua;
    String contra;
    Intent entrar;
    private  Cliente c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c=new Cliente(this);
        c.start();

        et_con=findViewById(R.id.et_con);

        et_usu=findViewById(R.id.et_usu);

        iv_imagen=findViewById(R.id.iv_imagen);

        btn_enviar=findViewById(R.id.btn_enviar);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                c.enviar();
                usua= et_usu.getText().toString();
                contra= et_con.getText().toString();
                Log.e("TEXTOR", usua+ " "+contra);

                cuenta = usua+";"+contra;
                Log.e("Info", cuenta);
                entrar=new Intent(getApplicationContext(),Cuenta.class);
                entrar.putExtra("usuario",usua);
            }
        });
    }

    @Override
    public void onReceived(final String mensaje) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,mensaje,Toast.LENGTH_SHORT).show();
                if(mensaje.equals("Usuario y contraseña incorrectos")){
                    iv_imagen.setImageResource(R.mipmap.ic_launcher);
                }
                if(mensaje.equals("Correcto")){
                    iv_imagen.setImageResource(R.mipmap.ic_launcher_round);
                    startActivity(entrar);
                }
            }
        });
    }



}
