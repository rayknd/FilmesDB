package desmob.ads.usjt.br.filmesdb.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeSet;

import desmob.ads.usjt.br.filmesdb.R;
import desmob.ads.usjt.br.filmesdb.model.Genero;
import desmob.ads.usjt.br.filmesdb.model.GeneroDAO;

public class ListaGeneroActivity extends Activity {

    public static final String GENERO1 = "desmob.ads.usjt.br.filmesdb.controllernomedogenero";
    private ArrayList<Genero> generos;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_lista_genero);

        Genero genero = new Genero();

        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.GENERO);

        generos = buscaGenero(chave);
        System.out.println(generos);
        ListView listView = findViewById(R.id.lista_genero);
        GeneroAdapter adapter = new GeneroAdapter(generos, this);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Genero genero = generos.get(i);
                Intent intent1 = new Intent(activity, DetalheGenero.class);
                intent1.putExtra(GENERO1, genero);
                startActivity(intent1);
            }

        });

    }

    private ArrayList<Genero> buscaGenero(String chave){
        ArrayList<Genero> resultado;
        System.out.println(chave);
        if(chave !=null && chave.length() > 0){
            resultado = new ArrayList<>();
            ArrayList<Genero> lista = listaGenero();
            for(Genero genero:lista){
                if(genero.getNome().toUpperCase().contains(chave.toUpperCase())){
                    resultado.add(genero);
                }
            }
            return resultado;
        }else{
            return listaGenero();
        }
    }


    private ArrayList<Genero> listaGenero(){
        ArrayList<Genero>lista = new ArrayList<>();
        Genero[] generos1 = GeneroDAO.getGenero();
        for(Genero genero:generos1){
            lista.add(genero);
            System.out.println(genero);
        }
        return lista;
    }
}
