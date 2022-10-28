package br.com.uniamerica.transportadora.transportadoraapi.controller;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Cidade;
import br.com.uniamerica.transportadora.transportadoraapi.repository.CidadeRepository;
import br.com.uniamerica.transportadora.transportadoraapi.service.CidadeService;
import org.apache.coyote.Response;
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

    @Autowired
    private CidadeRepository cidadeRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(
            @RequestBody Cidade cidade
    ) {
        try {
            this.cidadeService.save(cidade);
            return ResponseEntity.ok().body("A cidade foi registrada com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> listAll(

    ) {
        return ResponseEntity.ok().body(this.cidadeService.listAll());
    }

    @GetMapping("/estado")
    public ResponseEntity<?> findByEstado(
            @PathVariable("estado") Long estadoId
    ) {
        return ResponseEntity.ok().body(this.cidadeRepository.findByEstado(estadoId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> findById(
            @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok().body(this.cidadeService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Cidade cidade
    ) {
        try {
            this.cidadeService.update(id, cidade);
            return ResponseEntity.ok().body("A cidade foi atualizada com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(
            @PathVariable Long id,
            @RequestBody Cidade cidade
    ) {
        try {
            this.cidadeService.delete(id, cidade);
            return ResponseEntity.ok().body("A cidade foi deletada com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
