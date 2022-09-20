package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "td_fretes", schema = "transportadora")
public class Frete extends AbstractEntity {

    @Getter @Setter
    @JoinColumn(name = "id_produto", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Produto produto;

    @Getter @Setter
    @JoinColumn(name = "id_cidade_origem", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Cidade cidadeOrigem;

    @Getter @Setter
    @JoinColumn(name = "id_cidade_destino", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Cidade cidadeDestino;

    @Getter @Setter
    @JoinColumn(name = "id_motorista", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Usuario motorista;

    @Getter @Setter
    @JoinColumn(name = "id_caminhao", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
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
