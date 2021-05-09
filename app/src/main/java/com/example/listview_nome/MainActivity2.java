package com.example.listview_nome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Tela de cadastro de cliente.
 */

public class MainActivity2 extends AppCompatActivity {

    private TextView editTextClienteId;
    private TextView editTextNome;
    private TextView editTextCpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Associa os componentes aos atributos
        editTextNome = findViewById(R.id.editTextNome);
    }

    public void onClickBotaoSalvar(View v) {
        //Retorna os dados do cliente
        Intent data = new Intent();
        Bundle parms = new Bundle();
        //Se o nome é vazio retorna cancelado
        if (editTextNome.getText().toString().equals("")) {
            setResult(RESULT_CANCELED);
        } else {
            //Dados preenchido
            parms.putString("nome", editTextNome.getText().toString());
            data.putExtras(parms);
            setResult(RESULT_OK, data);
        }
        //Fecha a janela
        finish();
    }

    public void onClickBotaoVoltar(View v) {
        //finish();
        setResult(RESULT_CANCELED);
        finish();
    }
}