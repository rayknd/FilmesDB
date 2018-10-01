package desmob.ads.usjt.br.filmesdb.model;

public class FilmeDAO {
    public static Filme[] filmes;

    private FilmeDAO(){};

    public static Filme[] getGenero(){
        if(filmes == null){

            filmes = new Filme[19];
            filmes[0] = new Filme(1,"Aventura muito louca", "aventura",
                    "Aventura louca", "José", "12/04/2018", 10);
            filmes[1] = new Filme(2,"Ação na amazônia","acao",
                    "Ação demais", "Roberto", "03/04/1996", 8);
            filmes[2] = new Filme(3,"Animação do azilo winchester",
                    "animacao","Animação animada", "Guimarães", "25/12/2011", 7);
            filmes[3] = new Filme(4,"Comédia na sala", "comedia",
                    "Comédia", "Alberto", "12/12/12", 9);
            filmes[4] = new Filme(5,"Crime de abril", "crime",
                    "Crime num mês bacana", "Nobunaga", "20/05/2005", 7);
            filmes[5] = new Filme(6,"Documentário dos pubs","documentario",
                    "Documentário animal", "Ciro", "07/10/2018", 8);
            filmes[6] = new Filme(7,"Drama da serra elétrica", "drama",
                    "Drama forte", "Gomes", "07/07/2018", 5);
            filmes[7] = new Filme(8,"Família sinistra","familia",
                    "Família italiana", "EleNão", "07/10/2018", 10);
            filmes[8] = new Filme(9,"Fantasia nos alpes","fantasia",
                    "Fantasia", "Bozo", "17/03/1995", 10);
            filmes[9] = new Filme(10,"História e Eren","historia",
                    "História", "Bonato", "30/09/2014", 5);
            filmes[10] = new Filme(11,"Horror e Comédia","horror",
                    "Horror", "Carlos", "04/11/2003", 8);
            filmes[11] = new Filme(12,"Musical lindo", "musical",
                    "Musical", "Miguel", "26/01/2002", 9);
            filmes[12] = new Filme(13,"Mistério misterioso","misterio",
                    "Mistério", "Sanchez","14/11/2007", 2);
            filmes[13] = new Filme(14,"Romance em bankog", "romance",
                    "Romance", "João", "10/10/10", 3);
            filmes[14] = new Filme(15,"Ficção Científica","ficcao",
                    "Ficcao", "Rodrigo", "25/08/2015", 10);
            filmes[15] = new Filme(16,"Filmes para TV disney","tv",
                    "Filmes", "Takeshi","13/12/11", 5);
            filmes[16] = new Filme(17,"Suspense suspenso","suspense",
                    "Suspense", "Kovacs", "01/09/2009", 7);
            filmes[17] = new Filme(18,"Guerra Civil","guerra",
                    "Guerra", "Ortigoza", "10/03/1951", 8);
            filmes[18] = new Filme(19,"Western 'n wild","western",
                    "Western", "Neuma", "25/12/2016", 9);
        }


        return filmes;

    }

}
