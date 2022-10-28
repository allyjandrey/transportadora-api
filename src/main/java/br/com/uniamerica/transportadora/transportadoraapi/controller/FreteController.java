package br.com.uniamerica.transportadora.transportadoraapi.controller;

import br.com.uniamerica.transportadora.transportadoraapi.entity.StatusFrete;
import br.com.uniamerica.transportadora.transportadoraapi.repository.FreteRepository;
import br.com.uniamerica.transportadora.transportadoraapi.service.FreteService;
import br.com.uniamerica.transportadora.transportadoraapi.service.HistoricoFreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

public class FreteController {

    @Autowired
    private FreteRepository freteRepository;

    @Autowired
    private FreteService freteService;

    @PutMapping("/status/faturado/{idFrete}")
    public ResponseEntity<?> atualizarStatusFaturado(@PathVariable("idFrete") final Long idFrete) {
        try {
            this.freteService.atualizarStatusFaturado(idFrete);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Frete faturado com sucesso...");
    }

    @PutMapping("/status/em-transporte/{idFrete}")
    public ResponseEntity<?> atualizarStatusEmTransporte(@PathVariable("idFrete") final Long idFrete) {
        try {
            this.freteService.atualizarStatusEmTransporte(idFrete);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Frete iniciou seu transporte com sucesso...");
    }
}
