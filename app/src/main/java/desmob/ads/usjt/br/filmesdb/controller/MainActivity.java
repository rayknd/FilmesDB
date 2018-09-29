package desmob.ads.usjt.br.filmesdb.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import desmob.ads.usjt.br.filmesdb.R;

public class MainActivity extends Activity  {

    private Spinner spinner;
    private Button btnBuscar;
    private String genero;

   // public static final String CHAVE = "desmob.ads.usjt.br.filmesdb.controller.chave";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();

    }

    private void setupViews(){
        genero = "";
        btnBuscar = (Button) findViewById(R.id.botao_enviar);
        spinner = (Spinner) findViewById(R.id.spinner_generos);
        spinner.setOnItemSelectedListener(new GeneroSelecionado());
    }



    //Constante para identificar a mensagem
    public final static String GENERO = "desmob.ads.usjt.br.filmesdb.controller.genero";

    public void buscarGenero(View view){
        Intent intent = new Intent(this, ListaGeneroActivity.class);

        intent.putExtra(GENERO, genero);
        startActivity(intent);

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
