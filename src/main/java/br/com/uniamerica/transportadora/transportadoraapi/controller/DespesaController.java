package br.com.uniamerica.transportadora.transportadoraapi.controller;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Despesa;
import br.com.uniamerica.transportadora.transportadoraapi.repository.DespesaRepository;
import br.com.uniamerica.transportadora.transportadoraapi.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @Autowired
    private DespesaRepository despesaRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(
            @RequestBody Despesa despesa
    ) {
        try {
            this.despesaService.save(despesa);
            return ResponseEntity.ok().body("A despesa foi registrada");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Despesa>> listAll(

    ) {
        return ResponseEntity.ok().body(this.despesaService.listAll());
    }

    @GetMapping("/despesas/{id}")
    public ResponseEntity<Despesa> findById(
            @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok().body(this.despesaService.findById(id));
    }

    @PutMapping("/despesas/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Despesa despesa
    ) {
        try {
            this.despesaService.update(id, despesa);
            return ResponseEntity.ok().body("A despesa foi atualizada com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/despesas/{id}")
    public ResponseEntity<?> deletar(
            @PathVariable Long id,
            @RequestBody Despesa despesa
    ) {
        try {
            this.despesaService.delete(id, despesa);
            return ResponseEntity.ok().body("A despesa foi deletada com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/despesas-aprovadas/{freteId}")
    public ResponseEntity<?> findByFreteAndAprovadorIsNull(
            @PathVariable("freteId") Long freteId
    ) {
        return ResponseEntity.ok().body(this.despesaRepository.findByFreteAndAprovadorIsNull(freteId));
    }

}