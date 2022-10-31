package br.com.uniamerica.transportadora.transportadoraapi.controller;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Caminhao;
import br.com.uniamerica.transportadora.transportadoraapi.entity.HistoricoFrete;
import br.com.uniamerica.transportadora.transportadoraapi.repository.HistoricoFreteRepository;
import br.com.uniamerica.transportadora.transportadoraapi.service.HistoricoFreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HistoricoFreteController {

    @Autowired
    private HistoricoFreteService historicoFreteService;
    @Autowired
    private HistoricoFreteRepository historicoFreteRepository;

    @GetMapping
    public ResponseEntity<List<HistoricoFrete>> listAll(

    ) {
        return ResponseEntity.ok().body(this.historicoFreteService.listAll());
    }

    @GetMapping("/frete/{freteId}")
    public ResponseEntity<?> findByFrete(
            @PathVariable("freteId") Long freteId
    ) {
        return ResponseEntity.ok().body(this.historicoFreteRepository.findByFrete(freteId));
    }
}
