package desmob.ads.usjt.br.filmesdb.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import desmob.ads.usjt.br.filmesdb.R;
import desmob.ads.usjt.br.filmesdb.model.Filme;
import desmob.ads.usjt.br.filmesdb.model.FilmeDAO;

public class ListaFilmeActivity extends Activity {

    public static final String GENERO1 = "desmob.ads.usjt.br.filmesdb.controllernomedogenero";
    private ArrayList<Filme> filmes;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_lista_filme);

        Filme filme = new Filme();

        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.GENERO);

        filmes = buscaGenero(chave);
        System.out.println(filmes);
        ListView listView = findViewById(R.id.lista_genero);
        FilmeAdapter adapter = new FilmeAdapter(filmes, this);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Filme filme = filmes.get(i);
                Intent intent1 = new Intent(activity, DetalheFilme.class);
                intent1.putExtra(GENERO1, filme);
                startActivity(intent1);
            }

        });

    }

    private ArrayList<Filme> buscaGenero(String chave){
        ArrayList<Filme> resultado;
        System.out.println(chave);
        if(chave !=null && chave.length() > 0){
            resultado = new ArrayList<>();
            ArrayList<Filme> lista = listaGenero();
            for(Filme filme :lista){
                if(filme.getNome().toUpperCase().contains(chave.toUpperCase())){
                    resultado.add(filme);
                }
            }
            return resultado;
        }else{
            return listaGenero();
        }
    }


    private ArrayList<Filme> listaGenero(){
        ArrayList<Filme>lista = new ArrayList<>();
        Filme[] generos1 = FilmeDAO.getGenero();
        for(Filme filme :generos1){
            lista.add(filme);
            System.out.println(filme);
        }
        return lista;
    }
}
