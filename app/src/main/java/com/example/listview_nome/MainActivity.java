package com.example.listview_nome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button botaoAdicionar;
    private Button buttonFechar;
    private ListView listView;
    private List<String> listaNome = new ArrayList();
    private ListViewAdapterNome adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Associa os componentes da interface as propriedades
        botaoAdicionar = findViewById(R.id.buttonAdicionar);
        buttonFechar = findViewById(R.id.buttonFechar);

        // Adiciona alguns nomes para popular a lista
        listaNome.add("João");
        listaNome.add("Carlos");
        listaNome.add("Pedro");
        listaNome.add("Luiz");

        // Cria o Adapter para a lista de nomes e o listView
        adapter = new ListViewAdapterNome(listaNome, this);

        // Recupera o listView
        listView = (ListView) findViewById(R.id.listView);

        // Seta o adapter do listView
        listView.setAdapter(adapter);
    }

    public void onItemClick(View view, int position) {
        String nome = adapter.getItem(position);
        Toast.makeText(this, "Clique no nome: " + nome + " linha número: " + position, Toast.LENGTH_SHORT).show();
    }

    /**
     * Evento do botão adicionar cliente
     *
     * @param v
     */
    public void onClickBotaoAdicionar(View v) {
        // Recupera o intennt para a tela2
        Intent intent = new Intent(this, MainActivity2.class);
        // Abre a segunda tela
        startActivityForResult(intent, 0);
    }

    /**
     * Evento do botão remover cliente
     *
     * @param v
     */
    public void onClickBotaoRemover(View v) {
        // Retorna a posição da seleção
        int position = listView.getPositionForView((View) v.getParent());
        // Apaga o elemento da lista da posição
        adapter.remover(position);
    }

    /**
     * Evento do botão fechar
     *
     * @param v
     */
    public void onClickBotaoFechar(View v) {
        System.exit(0);
    }

    /**
     * Verifica o resultado do retorno da chamada de um activity.
     *
     * @param requestCode Código da requisição
     * @param resultCode  Código de retorno
     * @param data        Dados do intent
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Executa no retorno das telas
        super.onActivityResult(requestCode, resultCode, data);
        // Se o retorno foi Ok
        if (resultCode == RESULT_OK) {
            // Verifica se os dados foram preenchidos
            if (data.hasExtra("nome")) {
                String nome = data.getExtras().getString("nome");
                // Adiciona os dados na lsita
                adapter.adicionar(nome);
            }
        }
    }
}