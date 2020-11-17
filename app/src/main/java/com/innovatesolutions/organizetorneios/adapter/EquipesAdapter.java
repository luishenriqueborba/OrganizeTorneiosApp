package com.innovatesolutions.organizetorneios.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.model.Equipe;

import java.util.List;

public class EquipesAdapter extends BaseAdapter {

    Equipe equipe;

    private Context context;
    private List<Equipe> listEquipes;

    public EquipesAdapter(Context context, List<Equipe> listEquipes) {

        this.context = context;
        this.listEquipes = listEquipes;
    }


    @Override
    public int getCount() {
        return listEquipes.size();
    }

    @Override
    public Object getItem(int position) {
        return listEquipes.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View vista = view;
        LayoutInflater inflater = LayoutInflater.from(context);
        vista = inflater.inflate(R.layout.item_spinner_equipes, null);

        TextView nomeEquipe = (TextView) vista.findViewById(R.id.txtNomeEquipe);

        nomeEquipe.setText(listEquipes.get(position).getNome());

        return vista;
    }
}
