package desmob.ads.usjt.br.filmesdb.controller;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import desmob.ads.usjt.br.filmesdb.R;
import desmob.ads.usjt.br.filmesdb.model.Genero;
import desmob.ads.usjt.br.filmesdb.model.Util;

public class GeneroAdapter extends BaseAdapter{

    private ArrayList<Genero> generos;
    private Context context;

    public GeneroAdapter(ArrayList<Genero> generos, Context context){
        this.generos = generos;
        this.context = context;
    }

    @Override
    public int getCount(){return generos.size();}

    @Override
    public Object getItem(int i){return generos.get(i);}

    @Override
    public long  getItemId(int i){return i;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View linha = inflater.inflate(R.layout.linha_genero, viewGroup, false);
        ImageView fotoGenero = linha.findViewById(R.id.foto_genero);
        TextView linhaNome = linha.findViewById(R.id.linha_nome);
        TextView linhaDetalhe = linha.findViewById(R.id.linha_detalhe);

        Genero genero = generos.get(i);

        linhaNome.setText(genero.getNome());
        linhaDetalhe.setText(genero.getDescricao());

       //  Drawable drawable = Util.getDrawable(context, genero.getImagem());

        // fotoGenero.setImageDrawable(drawable);

        return linha;
    }
}
