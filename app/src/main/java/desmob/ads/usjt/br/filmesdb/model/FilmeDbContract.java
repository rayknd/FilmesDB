package desmob.ads.usjt.br.filmesdb.model;

import android.provider.BaseColumns;

public class FilmeDbContract {

    public FilmeDbContract() {}

    public static abstract class Filme implements BaseColumns {
        public static final String TABLE_NAME = "filme";
        public static final String ID = "id";
        public static final String TITULO = "titulo";
        public static final String GENERO = "genero";
        public static final String DESCRICAO = "descricao";
        public static final String DIRETOR = "diretor";
        public static final String DATA_LANCAMENTO = "data_lancamento";
        public static final String POPULARIDADE = "popularidade";
        public static final String IMAGEM = "imagem";
    }
}
