package desmob.ads.usjt.br.filmesdb.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;

import java.lang.reflect.Field;

import desmob.ads.usjt.br.filmesdb.R;

public class Util {


    public static Drawable getDrawable(Context context, String genero){
        Class<?> c = R.drawable.class;
        try {
            Field idField = c.getField(genero);
            int id = idField.getInt(idField);
            Drawable imagem = context.getResources().getDrawable(id);
            return  imagem;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return context.getResources().getDrawable(R.drawable.sorriso);
    }

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

}

