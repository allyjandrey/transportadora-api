package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_marcas", schema = "transportadora")
public class Marca extends AbstractEntity {

    @Getter
    @Setter
    @Column(name = "valor", length = 7, nullable = false)
    private String valor;
}
