package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "td_marcas", schema = "transportadora")
public class Marca extends AbstractEntity {

    @Getter @Setter
    private String valor;
}
