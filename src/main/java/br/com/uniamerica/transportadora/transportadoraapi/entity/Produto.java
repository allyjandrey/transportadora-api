package br.com.uniamerica.transportadora.transportadoraapi.entity;

public class Produto extends AbstractEntity {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
