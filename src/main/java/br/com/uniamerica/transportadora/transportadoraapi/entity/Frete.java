package br.com.uniamerica.transportadora.transportadoraapi.entity;

import java.math.BigDecimal;

public class Frete extends AbstractEntity {

    private Produto produto;

    private Cidade cidadeOrigem;

    private Cidade cidadeDestino;

    private Usuario motorista;

    private Caminhao caminhao;

    private StatusFrete statusFrete;

    private int quilometragemIni;

    private int quilometragemFim;

    private BigDecimal totalBrutoRecebidoNota;

    private BigDecimal totalLiquidoRecebido;

    private BigDecimal pesoInicial;

    private BigDecimal pesoFinal;

    private BigDecimal pesoFinalTransportado;

    private BigDecimal precoTonelada;

    private String observacao;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cidade getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(Cidade cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public Cidade getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(Cidade cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public Usuario getMotorista() {
        return motorista;
    }

    public void setMotorista(Usuario motorista) {
        this.motorista = motorista;
    }

    public Caminhao getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(Caminhao caminhao) {
        this.caminhao = caminhao;
    }

    public StatusFrete getStatusFrete() {
        return statusFrete;
    }

    public void setStatusFrete(StatusFrete statusFrete) {
        this.statusFrete = statusFrete;
    }

    public int getQuilometragemIni() {
        return quilometragemIni;
    }

    public void setQuilometragemIni(int quilometragemIni) {
        this.quilometragemIni = quilometragemIni;
    }

    public int getQuilometragemFim() {
        return quilometragemFim;
    }

    public void setQuilometragemFim(int quilometragemFim) {
        this.quilometragemFim = quilometragemFim;
    }

    public BigDecimal getTotalBrutoRecebidoNota() {
        return totalBrutoRecebidoNota;
    }

    public void setTotalBrutoRecebidoNota(BigDecimal totalBrutoRecebidoNota) {
        this.totalBrutoRecebidoNota = totalBrutoRecebidoNota;
    }

    public BigDecimal getTotalLiquidoRecebido() {
        return totalLiquidoRecebido;
    }

    public void setTotalLiquidoRecebido(BigDecimal totalLiquidoRecebido) {
        this.totalLiquidoRecebido = totalLiquidoRecebido;
    }

    public BigDecimal getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(BigDecimal pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public BigDecimal getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(BigDecimal pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public BigDecimal getPesoFinalTransportado() {
        return pesoFinalTransportado;
    }

    public void setPesoFinalTransportado(BigDecimal pesoFinalTransportado) {
        this.pesoFinalTransportado = pesoFinalTransportado;
    }

    public BigDecimal getPrecoTonelada() {
        return precoTonelada;
    }

    public void setPrecoTonelada(BigDecimal precoTonelada) {
        this.precoTonelada = precoTonelada;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
