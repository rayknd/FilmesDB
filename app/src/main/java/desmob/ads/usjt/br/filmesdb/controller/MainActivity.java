package desmob.ads.usjt.br.filmesdb.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import desmob.ads.usjt.br.filmesdb.R;
import desmob.ads.usjt.br.filmesdb.model.Filme;
import desmob.ads.usjt.br.filmesdb.model.FilmeDAO;
import desmob.ads.usjt.br.filmesdb.model.Genero;
import desmob.ads.usjt.br.filmesdb.model.GeneroDAO;
import desmob.ads.usjt.br.filmesdb.model.Util;


public class MainActivity extends Activity  {

    private Spinner spinner;
    private Button btnBuscar;
    private String genero;

    public static final String GENERO = "desmob.ads.usjt.br.filmesdb.controller.genero";
    public static final String FILMES = "desmob.ads.usjt.br.filmesdb.controller.filmes";
    public static final String HOSTFILME = "https://api.themoviedb.org/3/discover/movie";
    public static final String HOSTGENERO = "https://api.themoviedb.org/3/genre/movie/list?language=pt-BR";
    public static final String APIKEY = "?api_key=60b8c8663c5b8544a67b2192f513891f";
    public static final String URLFILME = "&language=pt-BR&include_adult=false&sort_by=popularity.desc";

    Intent intent;
    Context context;
    ArrayList<Genero> generos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        context = this;

    }

    private void setupViews(){
        genero = "";
        btnBuscar = (Button) findViewById(R.id.botao_enviar);
        spinner = (Spinner) findViewById(R.id.spinner_generos);
        spinner.setOnItemSelectedListener(new GeneroSelecionado());
    }




    public void buscarGenero(View view){
        Intent intent = new Intent(this, ListaFilmeActivity.class);

        if(Util.isConnected(this)) {
            if(spinner != null) {
                int idGenero = 0;
                generos = GeneroDAO.getGenero();
                for(Genero genero: generos) {
                    if(genero.getNome().toUpperCase().contains(spinner.toString().toUpperCase())) {
                        idGenero = genero.getId();
                    }
                }
                new DownloadFilmes().execute(HOSTFILME + APIKEY + URLFILME + "&with_genres=" + idGenero);
            }
            else {
                new DownloadFilmes().execute(HOSTFILME + APIKEY + URLFILME);
            }
        } else {
            Toast toast = Toast.makeText(this, "Conexão com a internet não encontrada. Utilizando cache.", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    private class DownloadFilmes extends AsyncTask<String, Void, ArrayList<Filme>> {

        @Override
        protected ArrayList<Filme> doInBackground(String... strings) {
            try {
                ArrayList<Filme> filmes = FilmeDAO.getFilmes(strings[0]);

                return filmes;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new ArrayList<Filme>();
        }

        protected void onPostExecute(ArrayList<Filme> filmes) {
            intent.putExtra(GENERO, (CharSequence) spinner);
            intent.putExtra(FILMES, filmes);
            startActivity(intent);
        }
    }




    private class GeneroSelecionado implements OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

            genero = (String) parent.getItemAtPosition(pos);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }



}
