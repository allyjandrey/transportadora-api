package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "td_fretes", schema = "transportadora")
public class Frete extends AbstractEntity {

    @ManyToOne
    @Getter @Setter
    private Produto produto;

    @ManyToOne
    @Getter @Setter
    private Cidade cidadeOrigem;

    @ManyToOne
    @Getter @Setter
    private Cidade cidadeDestino;

    @ManyToOne
    @Getter @Setter
    private Usuario motorista;

    @ManyToOne
    @Getter @Setter
    private Caminhao caminhao;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "status_frete", length = 15, nullable = false)
    private StatusFrete statusFrete;

    @Getter @Setter
    @Column(name = "quilometragem_ini", nullable = false)
    private int quilometragemIni;

    @Getter @Setter
    @Column(name = "quilometragem_fim", nullable = false)
    private int quilometragemFim;

    @Getter @Setter
    @Column(name = "total_bruto_recebido_nota", nullable = false, precision = 5, scale = 3)
    private BigDecimal totalBrutoRecebidoNota;

    @Getter @Setter
    @Column(name = "total_bruto_recebido", nullable = false, precision = 5, scale = 3)
    private BigDecimal totalLiquidoRecebido;

    @Getter @Setter
    @Column(name = "peso_inicial", nullable = false, precision = 5, scale = 3)
    private BigDecimal pesoInicial;

    @Getter @Setter
    @Column(name = "peso_final", nullable = false, precision = 5, scale = 3)
    private BigDecimal pesoFinal;

    @Getter @Setter
    @Column(name = "peso_final_transportado", nullable = false, precision = 5, scale = 3)
    private BigDecimal pesoFinalTransportado;

    @Getter @Setter
    @Column(name = "preco_tonelada", nullable = false, precision = 5, scale = 3)
    private BigDecimal precoTonelada;

    @Getter @Setter
    @Column(name = "observacao")
    private String observacao;
}
