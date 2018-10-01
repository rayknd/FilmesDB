package desmob.ads.usjt.br.filmesdb.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import desmob.ads.usjt.br.filmesdb.R;
import desmob.ads.usjt.br.filmesdb.model.Filme;
import desmob.ads.usjt.br.filmesdb.model.Util;

public class DetalheFilme extends Activity {
    private TextView nomeGenero, descricao, diretor, data, popularidade;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalhe_filme);
        nomeGenero = findViewById(R.id.txt_nome);
        diretor = findViewById(R.id.txt_diretor);
        data = findViewById(R.id.txt_data);
        popularidade = findViewById(R.id.txt_popularidade);
        descricao = findViewById(R.id.txt_descricao);

        foto = findViewById(R.id.detalhe_foto_filme);

        Intent intent = getIntent();
        Filme filme = (Filme)intent.getSerializableExtra(ListaFilmeActivity.GENERO1);

        nomeGenero.setText(filme.getNome());
        diretor.setText(filme.getNomeDiretor());
        data.setText(filme.getData());
        descricao.setText(filme.getDescricao());
        popularidade.setText(filme.getPopularidade() + "");

        foto.setImageDrawable(Util.getDrawable2(this, filme.getId()));
    }
}
