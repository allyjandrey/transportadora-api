package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "td_caminhoes", schema = "transportadora")
public class Caminhao extends AbstractEntity {

    @Getter @Setter
    private String placa;

    @ManyToOne
    @Getter @Setter
    private Modelo modelo;

    @Getter @Setter
    private int ano;

    @Getter @Setter
    private Cor cor;

    @Getter @Setter
    private String observacao;
}
