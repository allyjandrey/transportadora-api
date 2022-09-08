package br.com.uniamerica.transportadora.transportadoraapi.entity;

import java.time.LocalDateTime;

public abstract class AbstractEntity {

    public Long id;

    private LocalDateTime cadastro;

    private LocalDateTime alterado;

    private boolean ativo;


    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCadastrado() {
        return cadastro;
    }

    public void setCadastrado(LocalDateTime cadastrado) {
        this.cadastro = cadastrado;
    }

    public LocalDateTime getAtualizado() {
        return alterado;
    }

    public void setAtualizado(LocalDateTime atualizado) {
        this.alterado = atualizado;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
