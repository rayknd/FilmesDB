package desmob.ads.usjt.br.filmesdb.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Build;

import java.lang.reflect.Field;
import java.text.Normalizer;

import desmob.ads.usjt.br.filmesdb.R;

public class Util {


    public static Drawable getDrawable2(Context context, int idFilme){
        Class<?> c = R.drawable.class;
        try {
            Field idField = c.getField("filme" + Integer.toString(idFilme));
            int id = idField.getInt(idField);
            Drawable imagem = context.getResources().getDrawable(id);
            return imagem;
        } catch (NoSuchFieldException e){
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }

        return context.getResources().getDrawable(R.drawable.sorriso);
    }

    //genero
    public static Drawable getDrawable(Context context, String genero){
        Class<?> c = R.drawable.class;
        try{
            Field idField = c.getField(retiraEspacoGenero(genero));
            int id = idField.getInt(idField);
            Drawable imagem = context.getResources().getDrawable(id);
            return imagem;
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return context.getResources().getDrawable(R.drawable.sorriso);
    }

    public static String retiraEspacoGenero(String genero){
        if(genero != null){
            genero = genero.toLowerCase().replace(' ', '_' );
            return removeCaracterEspecial(genero.replace('.', '_'));
        }else{
            return genero;
        }
    }

    public static String removeCaracterEspecial(String genero){
        return Normalizer.normalize(genero, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    public static boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

}

