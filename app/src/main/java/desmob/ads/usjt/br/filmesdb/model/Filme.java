package desmob.ads.usjt.br.filmesdb.model;

import java.io.Serializable;

public class Filme implements Serializable{

    private String nome, genero, descricao, imagem, nomeDiretor, data;
    private int id;
    private double popularidade;

    public Filme(){

    }

    public Filme(int id, String nome, String genero,String descricao, String nomeDiretor, String data,
    double popularidade, String imagem){
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.descricao = descricao;
        this.nomeDiretor = nomeDiretor;
        this.data = data;
        this.popularidade = popularidade;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero){this.genero = genero;}

    public String getGenero(){ return genero; }

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

    public void setNomeDiretor(String nomeDiretor) {this.nomeDiretor = nomeDiretor;}

    public String getNomeDiretor() {return nomeDiretor;}

    public String getData() { return data; }

    public void setData(String data) { this.data = data; }

    public double getPopularidade() {
        return popularidade;
    }

    public void setPopularidade(double popularidade) {
        this.popularidade = popularidade;
    }

    @Override
    public String toString(){
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", diretor='" + nomeDiretor + '\'' +
                ", genero='" + genero + '\'' +
                ", descrição='" + descricao + '\'' +
                ", data='" + data + '\'' +
                ", data='" + imagem + '\'' +
                ", popularidade='" + popularidade + '\'' +
                ", id=" + id + '}';
    }
}
