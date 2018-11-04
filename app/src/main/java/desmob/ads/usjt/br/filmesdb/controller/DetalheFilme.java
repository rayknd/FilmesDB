package desmob.ads.usjt.br.filmesdb.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import desmob.ads.usjt.br.filmesdb.R;
import desmob.ads.usjt.br.filmesdb.model.Filme;
import desmob.ads.usjt.br.filmesdb.model.FilmeDAO;
import desmob.ads.usjt.br.filmesdb.model.Util;

public class DetalheFilme extends Activity {
    private TextView nomeFilme, descricao, diretor, data, popularidade;
    private ImageView foto;
    private Context context;
    public static final String HOSTIMAGE = "http://image.tmdb.org/t/p/w185";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filme);
        context = this;

        nomeFilme = findViewById(R.id.txt_nome);
        diretor = findViewById(R.id.txt_diretor);
        data = findViewById(R.id.txt_data);
        popularidade = findViewById(R.id.txt_popularidade);
        descricao = findViewById(R.id.txt_descricao);

        foto = findViewById(R.id.detalhe_foto_filme);

        Intent intent = getIntent();
        Filme filme = (Filme)intent.getSerializableExtra(ListaFilmeActivity.FILME);

        nomeFilme.setText(filme.getNome());
        diretor.setText(filme.getNomeDiretor());
        data.setText(filme.getData());
        descricao.setText(filme.getDescricao());
        popularidade.setText(Double.toString(filme.getPopularidade()));


        //Para baixar a imagem
        new DownloadImagem().execute(HOSTIMAGE+filme.getImagem());
    }

    private class DownloadImagem extends AsyncTask<String, Void, Bitmap> {


        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap imagem = null;
            try {
                imagem = FilmeDAO.getImagem(strings[0]);
            }catch (IOException e) {
                e.printStackTrace();
            }

            if (imagem == null) {
                imagem = ((BitmapDrawable)context.getDrawable(R.drawable.sorriso)).getBitmap();
            }
            return imagem;
        }

        protected void onPostExecute(Bitmap imagem) {
            foto.setImageBitmap(imagem);
        }
    }
}
