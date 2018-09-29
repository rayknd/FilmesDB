package desmob.ads.usjt.br.filmesdb.model;

import java.io.Serializable;

public class Genero implements Serializable{

    private String nome, descricao, imagem;
    private int id;

    public Genero(){

    }

    public Genero(int id, String nome, String descricao){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImagem(String imagem){this.imagem = imagem;}

    public String getImagem(){
        return imagem;
    }

    @Override
    public String toString(){
        return "Genero{" +
                "nome='" + nome + '\'' +
                ", descrição='" + descricao + '\'' +
                ", id=" + id + '}';
    }




}
