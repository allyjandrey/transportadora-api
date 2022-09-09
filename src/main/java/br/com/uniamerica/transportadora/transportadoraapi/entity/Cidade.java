package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "td_cidades", schema = "transportadora")
public class Cidade extends AbstractEntity {

    @Getter @Setter
    private String nome;

    @ManyToOne
    @Getter @Setter
    private Estado estado;
}
