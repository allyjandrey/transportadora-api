package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "td_historicos_frete", schema = "transportadora")
public class HistoricoFrete extends AbstractEntity {

    @Getter @Setter
    private LocalDateTime data;

    @ManyToOne
    @Getter @Setter
    private Frete frete;

    @Getter @Setter
    private StatusFrete statusFrete;

    @ManyToOne
    @Getter @Setter
    private Usuario executor;
}
