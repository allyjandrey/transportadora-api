package br.com.uniamerica.transportadora.transportadoraapi.controller;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Usuario;
import br.com.uniamerica.transportadora.transportadoraapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/tipoDespesa")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> cadastrar(
            @RequestBody Usuario usuario
    ){
        try{
            this.usuarioService.save(usuario);
            return ResponseEntity.ok().body("O usuário foi registrado...");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listAll(

    ){
        return ResponseEntity.ok().body(this.usuarioService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok().body(this.usuarioService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Usuario usuario
    ){
        try{
            this.usuarioService.update(id, usuario);
            return ResponseEntity.ok().body("O usuário foi atualizado com sucesso...");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(
            @PathVariable Long id,
            @RequestBody Usuario usuario
    ){
        try{
            this.usuarioService.delete(id, usuario);
            return ResponseEntity.ok().body("O usuário foi deletado com sucesso...");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
