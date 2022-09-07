package br.com.uniamerica.transportadora.transportadoraapi.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Usuario extends AbstractEntity {

    private BigDecimal percGanho;

    private String login;

    private String senha;

    private Grupo grupo;

    private String nome;

    private String cpf;

    private String telefone;

    private Date dataNascimento;

    private String endereco;

    private String observacao;

    public BigDecimal getPercGanho() {
        return percGanho;
    }

    public void setPercGanho(BigDecimal percGanho) {
        this.percGanho = percGanho;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
