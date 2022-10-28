package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_modelos", schema = "transportadora")
public class Modelo extends AbstractEntity {

    @Getter
    @Setter
    @Column(name = "nome", length = 15, nullable = false)
    private String nome;

    @Getter
    @Setter
    @JoinColumn(name = "id_marca", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Marca marca;
}
