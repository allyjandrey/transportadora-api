package br.com.uniamerica.transportadora.transportadoraapi.entity;

public class Modelo extends AbstractEntity {

    private String nome;

    private Marca marca;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
