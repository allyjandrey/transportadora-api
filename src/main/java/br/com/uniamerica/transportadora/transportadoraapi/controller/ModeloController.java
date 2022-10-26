package br.com.uniamerica.transportadora.transportadoraapi.controller;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Modelo;
import br.com.uniamerica.transportadora.transportadoraapi.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/modelos")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @PostMapping
    public ResponseEntity<?> cadastrar(
            @RequestBody Modelo modelo
    ){
        try{
            this.modeloService.save(modelo);
            return ResponseEntity.ok().body("O modelo foi registrado com sucesso");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Modelo>> listAll(

    ){
        return ResponseEntity.ok().body(this.modeloService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> findById(
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok().body(this.modeloService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Modelo modelo
    ){
        try{
            this.modeloService.update(id, modelo);
            return ResponseEntity.ok().body("O modelo foi atualizado com sucesso");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(
            @PathVariable Long id,
            @RequestBody Modelo modelo
    ){
        try{
            this.modeloService.delete(id, modelo);
            return ResponseEntity.ok().body("O modelo foi deletado com sucesso");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}