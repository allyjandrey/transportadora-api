package br.com.uniamerica.transportadora.transportadoraapi.controller;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Caminhao;
import br.com.uniamerica.transportadora.transportadoraapi.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@Controller
@RequestMapping("/api/Caminhoes")
public class CaminhaoController {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    @GetMapping
    public ResponseEntity<List<Caminhao>> findAll(){
    return ResponseEntity.ok().body(this.caminhaoRepository.findByAtivoTrue());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id){
        return ResponseEntity.ok().body(this.caminhaoRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Caminhao placa, final Caminhao modelo, final Caminhao ano) {
        this.caminhaoRepository.save(placa);
        this.caminhaoRepository.save(modelo);
        this.caminhaoRepository.save(ano);
        return ResponseEntity.ok().body("Caminhao cadastrado com sucesso!");
    }
}
