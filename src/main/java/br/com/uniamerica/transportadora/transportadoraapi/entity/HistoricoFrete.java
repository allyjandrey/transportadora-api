package br.com.uniamerica.transportadora.transportadoraapi.entity;

import java.time.LocalDateTime;

public class HistoricoFrete extends AbstractEntity {

    private LocalDateTime data;

    private Frete frete;

    private StatusFrete statusFrete;

    private Usuario executor;

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Frete getFrete() {
        return frete;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }

    public StatusFrete getStatusFrete() {
        return statusFrete;
    }

    public void setStatusFrete(StatusFrete statusFrete) {
        this.statusFrete = statusFrete;
    }

    public Usuario getExecutor() {
        return executor;
    }

    public void setExecutor(Usuario executor) {
        this.executor = executor;
    }
}
