package br.com.uniamerica.transportadora.transportadoraapi.controller;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Despesa;
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

    @PostMapping
    public ResponseEntity<?> cadastrar(
            @RequestBody Despesa despesa
    ){
        try{
            this.despesaService.save(despesa);
            return ResponseEntity.ok().body("A despesa foi registrada...");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Despesa>> listAll(

    ){
        return ResponseEntity.ok().body(this.despesaService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despesa> findById(
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok().body(this.despesaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Despesa despesa
    ){
        try{
            this.despesaService.update(id, despesa);
            return ResponseEntity.ok().body("A despesa foi atualizada com sucesso...");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(
            @PathVariable Long id,
            @RequestBody Despesa despesa
    ){
        try{
            this.despesaService.delete(id, despesa);
            return ResponseEntity.ok().body("A despesa foi deletada com sucesso...");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}