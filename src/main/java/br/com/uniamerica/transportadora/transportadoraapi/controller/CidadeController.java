package br.com.uniamerica.transportadora.transportadoraapi.controller;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Cidade;
import br.com.uniamerica.transportadora.transportadoraapi.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/api/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<?> cadastrar(
            @RequestBody Cidade cidade
    ){
        try{
            this.cidadeService.save(cidade);
            return ResponseEntity.ok().body("A cidade foi registrada...");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> listAll(

    ){
        return ResponseEntity.ok().body(this.cidadeService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> findById(
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok().body(this.cidadeService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Cidade cidade
    ){
        try{
            this.cidadeService.update(id, cidade);
            return ResponseEntity.ok().body("A cidade foi atualizada com sucesso...");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(
            @PathVariable Long id,
            @RequestBody Cidade cidade
    ){
        try{
            this.cidadeService.delete(id, cidade);
            return ResponseEntity.ok().body("A cidade foi deletada com sucesso...");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
