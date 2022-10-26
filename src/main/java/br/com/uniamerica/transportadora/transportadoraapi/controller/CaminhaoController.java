package br.com.uniamerica.transportadora.transportadoraapi.controller;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Caminhao;
import br.com.uniamerica.transportadora.transportadoraapi.service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/caminhoes")
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;

    @PostMapping
    public ResponseEntity<?> cadastrar(
            @RequestBody Caminhao caminhao
    ){
        try{
            this.caminhaoService.save(caminhao);
            return ResponseEntity.ok().body("Caminhão cadastrado...");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Caminhao>> listAll(

    ){
        return ResponseEntity.ok().body(this.caminhaoService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caminhao> findById(
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok().body(this.caminhaoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long idCaminhao,
            @RequestBody Caminhao caminhao
    ){
        try{
            this.caminhaoService.update(idCaminhao, caminhao);
            return ResponseEntity.ok().body("Caminhão atualizado com sucesso...");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{idCaminhao}")
    public ResponseEntity<?> deletar(
            @PathVariable Long idCaminhao,
            @RequestBody Caminhao caminhao
    ){
        try{
            this.caminhaoService.delete(idCaminhao, caminhao);
            return ResponseEntity.ok().body("Caminhão deletado com sucesso...");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
