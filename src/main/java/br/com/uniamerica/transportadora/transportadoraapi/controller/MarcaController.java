package br.com.uniamerica.transportadora.transportadoraapi.controller;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Marca;
import br.com.uniamerica.transportadora.transportadoraapi.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @PostMapping
    public ResponseEntity<?> cadastrar(
            @RequestBody Marca marca
    ) {
        try {
            this.marcaService.save(marca);
            return ResponseEntity.ok().body("A marca foi registrada com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Marca>> listAll(

    ) {
        return ResponseEntity.ok().body(this.marcaService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> findById(
            @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok().body(this.marcaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Marca marca
    ) {
        try {
            this.marcaService.atualizar(id, marca);
            return ResponseEntity.ok().body("A marca foi atualizada com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(
            @PathVariable Long id,
            @RequestBody Marca marca
    ) {
        try {
            this.marcaService.deletar(id, marca);
            return ResponseEntity.ok().body("A marca foi deletada com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}