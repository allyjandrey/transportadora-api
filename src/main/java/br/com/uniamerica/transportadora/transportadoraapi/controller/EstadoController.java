package br.com.uniamerica.transportadora.transportadoraapi.controller;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Estado;
import br.com.uniamerica.transportadora.transportadoraapi.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public ResponseEntity<?> cadastrar(
            @RequestBody Estado estado
    ){
        try{
            this.estadoService.save(estado);
            return ResponseEntity.ok().body("O estado foi registrado...");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Estado>> listAll(

    ){
        return ResponseEntity.ok().body(this.estadoService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> findById(
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok().body(this.estadoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Estado estado
    ){
        try{
            this.estadoService.update(id, estado);
            return ResponseEntity.ok().body("O estado  foi atualizado com sucesso...");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(
            @PathVariable Long id,
            @RequestBody Estado estado
    ){
        try{
            this.estadoService.delete(id, estado);
            return ResponseEntity.ok().body("O estado foi deletado com sucesso...");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}