package br.com.uniamerica.transportadora.transportadoraapi.controller;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Estado;
import br.com.uniamerica.transportadora.transportadoraapi.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public ResponseEntity<List<Estado>> findAll(){
        return ResponseEntity.ok().body(this.estadoRepository.findByAtivoFalse());
    }

    @GetMapping("/filtro/{nome}")
    public ResponseEntity<List<Estado>> findAllNome(
            @PathVariable("nome") final String nome
    ){
        return ResponseEntity.ok().body(this.estadoRepository.findByNomeAndAtivoTrue(nome));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Estado estado){
        this.estadoRepository.save(estado);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody final Estado estado
    ){
        final Estado estado = this.estadoRepository

        if(id.equals(estado.getId()) && this.estadoRepository.findById(id).isEmpty()){
            this.estadoRepository.save(estado);
        }
        else {
            return ResponseEntity.badRequest().body("Id não encontrado");
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso...");
    }
}

