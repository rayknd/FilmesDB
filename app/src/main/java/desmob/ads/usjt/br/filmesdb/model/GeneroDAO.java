package desmob.ads.usjt.br.filmesdb.model;

public class GeneroDAO {
    public static Genero[] generos;

    private GeneroDAO(){};

    public static Genero[] getGenero(){
        if(generos == null){

            generos = new Genero[19];
            generos[0] = new Genero(1,"Aventura muito louca","Aventura louca");
            generos[1] = new Genero(2,"Ação na amazônia","Ação demais");
            generos[2] = new Genero(3,"Animação do azilo winchester","Animação animada");
            generos[3] = new Genero(4,"Comédia na sala","Comédia");
            generos[4] = new Genero(5,"Crime de abril","Crime num mês bacana");
            generos[5] = new Genero(6,"Documentário dos pubs","Documentário animal");
            generos[6] = new Genero(7,"Drama da serra elétrica","Drama forte");
            generos[7] = new Genero(8,"Família sinistra","Família italiana");
            generos[8] = new Genero(9,"Fantasia nos alpes","Fantasia");
            generos[9] = new Genero(10,"História e Eren","História");
            generos[10] = new Genero(11,"Horror e Comédia","Horror");
            generos[11] = new Genero(12,"Musical lindo","Musical");
            generos[12] = new Genero(13,"Mistério misterioso","Mistério");
            generos[13] = new Genero(14,"Romance em bankog","Romance");
            generos[14] = new Genero(15,"Ficção Científica","Ficcao");
            generos[15] = new Genero(16,"Filmes para TV disney","Filmes");
            generos[16] = new Genero(17,"Suspense suspenso","Suspense");
            generos[17] = new Genero(18,"Guerra Civil","Guerra");
            generos[18] = new Genero(19,"Western 'n wild","Western");
        }


        return generos;

    }

}
