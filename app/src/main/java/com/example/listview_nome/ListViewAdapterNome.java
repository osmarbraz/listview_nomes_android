package com.example.listview_nome;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapterNome extends BaseAdapter {

    private List<String> listaNomes;
    private Activity activity;

    ListViewAdapterNome(List<String> listaNomes, Activity activity) {
        this.listaNomes = listaNomes;
        this.activity = activity;
    }

    /**
     * Retorna a quantidade de elementos da lista
     * @return A quantidade de elementos da lista.
     */
    @Override
    public int getCount() {
        return listaNomes.size();
    }

    /**
     * Retorna um elemento de uma posição da lista
     * @param i Posição do elemento a ser retornado.
     * @return Um elemento da posição i
     */
    @Override
    public String getItem(int i) {
        return listaNomes.get(i);
    }

    /**
     * Obtêm os dados na posição de clique
     * @param id Posição do item.
     * @return
     */
    @Override
    public long getItemId(int id) {
        return 0;
    }

    /**
     * Atualiza os componentes da lista
     * @param posicao
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null) {
            v = activity.getLayoutInflater().inflate(R.layout.item_nome_view, viewGroup, false);
        }
        String nome = listaNomes.get(posicao);
        TextView textViewNome = (TextView) v.findViewById(R.id.textViewNome);
        textViewNome.setText(nome);
        return v;
    }

    /**
     * Adiciona um novo nome a lista
     *
     * @param novo Um nome
     */
    public void adicionar(String novo) {
        // Adiciona o item na ultima posicao
        listaNomes.add(novo);
        // Notifica o ListView que os dados foram atualizados
        notifyDataSetChanged();
    }

    /**
     * Remove um nome da lista pela posição
     *
     * @param posicao Posição do nome a ser excluído
     */
    public void remover(int posicao) {
        // Remove o item na posicao desejada
        listaNomes.remove(posicao);
        // Notifica o ListView que os dados foram atualizados
        notifyDataSetChanged();
    }
}