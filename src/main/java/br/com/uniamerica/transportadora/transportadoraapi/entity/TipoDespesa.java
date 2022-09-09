package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "td_tipos_despesa", schema = "transportadora")
public class TipoDespesa extends AbstractEntity {

    @Getter @Setter
    private String nome;
}
