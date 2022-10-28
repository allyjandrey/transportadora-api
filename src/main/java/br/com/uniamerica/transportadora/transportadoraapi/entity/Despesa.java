package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_despesas", schema = "transportadora")
public class Despesa extends AbstractEntity {

    @Getter
    @Setter
    @JoinColumn(name = "id_tipo_despesa", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private TipoDespesa tipoDespesa;

    @Getter
    @Setter
    @Column(name = "valor", nullable = false, precision = 5, scale = 3)
    private BigDecimal valor;

    @Getter
    @Setter
    @JoinColumn(name = "id_motorista", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Usuario motorista;

    @Getter
    @Setter
    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    @Getter
    @Setter
    @JoinColumn(name = "id_aprovador", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Usuario aprovador;

    @Getter
    @Setter
    @JoinColumn(name = "id_frete", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Frete frete;
}
