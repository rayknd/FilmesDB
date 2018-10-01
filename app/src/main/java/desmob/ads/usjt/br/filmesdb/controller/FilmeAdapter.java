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
import desmob.ads.usjt.br.filmesdb.model.Filme;
import desmob.ads.usjt.br.filmesdb.model.Util;

public class FilmeAdapter extends BaseAdapter{

    private ArrayList<Filme> filmes;
    private Context context;

    public FilmeAdapter(ArrayList<Filme> filmes, Context context){
        this.filmes = filmes;
        this.context = context;
    }

    @Override
    public int getCount(){return filmes.size();}

    @Override
    public Object getItem(int i){return filmes.get(i);}

    @Override
    public long  getItemId(int i){return i;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        View linha = view;
        if(linha == null) {

            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            linha = inflater.inflate(R.layout.linha_filme, viewGroup, false);

            ImageView fotoGenero = (ImageView)linha.findViewById(R.id.foto_genero);
            TextView linhaNome = (TextView)linha.findViewById(R.id.linha_nome);
            TextView linhaDetalhe = (TextView)linha.findViewById(R.id.linha_detalhe);

            ViewHolder holder = new ViewHolder(fotoGenero, linhaNome, linhaDetalhe);
            linha.setTag(holder);
        }

            Filme filme = filmes.get(i);
            ViewHolder holder = (ViewHolder)linha.getTag();

            holder.getLinha1().setText((filme.getNome() + " - ID " + filme.getId()));
            holder.getLinha2().setText((filme.getNomeDiretor() + " - " + filme.getData()));

            /*
            linhaNome.setText(filme.getNome());
            linhaDetalhe.setText(filme.getDescricao());
            */

            Drawable drawable = Util.getDrawable(context, filme.getGenero());

            holder.getImagem().setImageDrawable(drawable);

            //fotoGenero.setImageDrawable(drawable);

        return linha;
    }
}
