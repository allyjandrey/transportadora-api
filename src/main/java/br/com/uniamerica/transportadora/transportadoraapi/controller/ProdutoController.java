package br.com.uniamerica.transportadora.transportadoraapi.controller;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Produto;
import br.com.uniamerica.transportadora.transportadoraapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<?> cadastrar(
            @RequestBody Produto produto
    ) {
        try {
            this.produtoService.save(produto);
            return ResponseEntity.ok().body("O produto foi registrado com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listAll(

    ) {
        return ResponseEntity.ok().body(this.produtoService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(
            @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok().body(this.produtoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Produto produto
    ) {
        try {
            this.produtoService.update(id, produto);
            return ResponseEntity.ok().body("O produto foi atualizado com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(
            @PathVariable Long id,
            @RequestBody Produto produto
    ) {
        try {
            this.produtoService.delete(id, produto);
            return ResponseEntity.ok().body("O produto foi deletado com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}