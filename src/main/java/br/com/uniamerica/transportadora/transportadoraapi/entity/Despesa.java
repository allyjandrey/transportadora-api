package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "td_despesas", schema = "transportadora")
public class Despesa extends AbstractEntity {

    @ManyToOne
    @Getter @Setter
    private TipoDespesa tipoDespesa;

    @Getter @Setter
    private BigDecimal valor;

    @ManyToOne
    @Getter @Setter
    private Usuario motorista;

    @Getter @Setter
    private LocalDateTime data;

    @ManyToOne
    @Getter @Setter
    private Usuario aprovador;

    @ManyToOne
    @Getter @Setter
    private Frete frete;
}
