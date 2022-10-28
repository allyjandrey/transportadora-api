package br.com.uniamerica.transportadora.transportadoraapi.controller;

import br.com.uniamerica.transportadora.transportadoraapi.entity.TipoDespesa;
import br.com.uniamerica.transportadora.transportadoraapi.service.TipoDespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/tipoDespesas")
public class TipoDespesaController {

    @Autowired
    private TipoDespesaService tipoDespesaService;

    @PostMapping
    public ResponseEntity<?> cadastrar(
            @RequestBody TipoDespesa tipoDespesa
    ) {
        try {
            this.tipoDespesaService.save(tipoDespesa);
            return ResponseEntity.ok().body("O tipo da despesa foi registrada com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<TipoDespesa>> listAll(

    ) {
        return ResponseEntity.ok().body(this.tipoDespesaService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDespesa> findById(
            @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok().body(this.tipoDespesaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody TipoDespesa tipoDespesa
    ) {
        try {
            this.tipoDespesaService.update(id, tipoDespesa);
            return ResponseEntity.ok().body("O tipo da despesa foi atualizada com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(
            @PathVariable Long id,
            @RequestBody TipoDespesa tipoDespesa
    ) {
        try {
            this.tipoDespesaService.delete(id, tipoDespesa);
            return ResponseEntity.ok().body("O tipo da despesa foi deletada com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}