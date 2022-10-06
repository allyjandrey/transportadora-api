package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_cidades", schema = "transportadora",
        uniqueConstraints = {
            @UniqueConstraint(
                    columnNames = {"nome", "estados_id"}
            )
        }
)
public class Cidade extends AbstractEntity {

    @Getter @Setter
    @Column(name = "nome", length = 15, nullable = false)
    private String nome;

    @Getter @Setter
    @JoinColumn(name = "estados_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Estado estado;
}
