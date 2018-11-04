package desmob.ads.usjt.br.filmesdb.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import desmob.ads.usjt.br.filmesdb.R;
import desmob.ads.usjt.br.filmesdb.model.Filme;
import desmob.ads.usjt.br.filmesdb.model.FilmeDAO;

public class ListaFilmeActivity extends Activity {

    public static final String FILME = "desmob.ads.usjt.br.filmesdb.controller.filme";
    private ArrayList<Filme> filmes;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_lista_filme);


        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.GENERO);

        //filmes = buscaGenero(chave);

        filmes = (ArrayList<Filme>) intent.getSerializableExtra(MainActivity.FILMES);

        ListView listView = findViewById(R.id.lista_filmes);
        FilmeAdapter adapter = new FilmeAdapter(filmes, this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Filme filme = filmes.get(i);
                Intent intent = new Intent(activity, DetalheFilme.class);
                intent.putExtra(FILME, filme);
                startActivity(intent);
            }

        });

    }

}
