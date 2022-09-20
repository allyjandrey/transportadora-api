package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "td_caminhoes", schema = "transportadora")
public class Caminhao extends AbstractEntity {

    @Getter @Setter
    @Column(name = "placa", length = 15, nullable = false, unique = true)
    private String placa;

    @Getter @Setter
    @JoinColumn(name = "id_modelo", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Modelo modelo;

    @Getter @Setter
    @Column(name = "ano", nullable = false)
    private int ano;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "cor", length = 15, nullable = false)
    private Cor cor;

    @Getter @Setter
    @Column(name = "observacao")
    private String observacao;
}
