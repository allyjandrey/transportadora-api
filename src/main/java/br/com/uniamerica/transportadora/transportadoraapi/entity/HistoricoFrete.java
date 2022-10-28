package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_historicos_frete", schema = "transportadora")
public class HistoricoFrete extends AbstractEntity {

    @Getter
    @Setter
    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    @Getter
    @Setter
    @JoinColumn(name = "id_estado", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Frete frete;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "status_frete", length = 15, nullable = false)
    private StatusFrete statusFrete;

    @Getter
    @Setter
    @JoinColumn(name = "id_executor", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Usuario executor;
}
