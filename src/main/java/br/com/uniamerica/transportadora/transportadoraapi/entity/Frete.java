package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
    private StatusFrete statusFrete;

    @Getter @Setter
    private int quilometragemIni;

    @Getter @Setter
    private int quilometragemFim;

    @Getter @Setter
    private BigDecimal totalBrutoRecebidoNota;

    @Getter @Setter
    private BigDecimal totalLiquidoRecebido;

    @Getter @Setter
    private BigDecimal pesoInicial;

    @Getter @Setter
    private BigDecimal pesoFinal;

    @Getter @Setter
    private BigDecimal pesoFinalTransportado;

    @Getter @Setter
    private BigDecimal precoTonelada;

    @Getter @Setter
    private String observacao;
}
