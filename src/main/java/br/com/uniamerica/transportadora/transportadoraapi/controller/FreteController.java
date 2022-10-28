package br.com.uniamerica.transportadora.transportadoraapi.controller;

import br.com.uniamerica.transportadora.transportadoraapi.repository.FreteRepository;
import br.com.uniamerica.transportadora.transportadoraapi.service.FreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

public class FreteController {

    @Autowired
    private FreteRepository freteRepository;

    @Autowired
    private FreteService freteService;

    @PutMapping("/status/carga/{idFrete}")
    public ResponseEntity<?> atualizarStatusCarga(@PathVariable("idFrete") final Long idFrete) {
        try {
            this.freteService.atualizarStatusCarga(idFrete);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("O frete está atualmente em carga");
    }

    @PutMapping("/status/em-transporte/{idFrete}")
    public ResponseEntity<?> atualizarStatusEmTransporte(@PathVariable("idFrete") final Long idFrete) {
        try {
            this.freteService.atualizarStatusEmTransporte(idFrete);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("O frete iniciou seu transporte com sucesso");
    }

    @PutMapping("/status/interrompido/{idFrete}")
    public ResponseEntity<?> atualizarStatusInterrompido(@PathVariable("idFrete") final Long idFrete) {
        try {
            this.freteService.atualizarStatusInterrompido(idFrete);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("O frete foi interrompido com sucesso");
    }

    @PutMapping("/status/faturado/{idFrete}")
    public ResponseEntity<?> atualizarStatusDescarga(@PathVariable("idFrete") final Long idFrete) {
        try {
            this.freteService.atualizarStatusDescarga(idFrete);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("O frete está atualmente em descarga");
    }

    @PutMapping("/status/faturado/{idFrete}")
    public ResponseEntity<?> atualizarStatusFaturado(@PathVariable("idFrete") final Long idFrete) {
        try {
            this.freteService.atualizarStatusFaturado(idFrete);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("O frete foi faturado com sucesso");
    }

    @PutMapping("/status/faturado/{idFrete}")
    public ResponseEntity<?> atualizarStatusCancelado(@PathVariable("idFrete") final Long idFrete) {
        try {
            this.freteService.atualizarStatusCancelado(idFrete);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("O frete foi cancelado com sucesso");
    }
}
