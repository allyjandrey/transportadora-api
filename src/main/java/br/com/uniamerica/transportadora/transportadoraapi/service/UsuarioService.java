package br.com.uniamerica.transportadora.transportadoraapi.service;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Usuario;
import br.com.uniamerica.transportadora.transportadoraapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario save(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public List<Usuario> listAll() {
        return this.usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return this.usuarioRepository.findById(id).orElse(new Usuario());
    }

    @Transactional
    public void atualizar(Long id, Usuario usuario) {
        if (id == usuario.getId()) {
            this.usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void deletar(Long id, Usuario usuario) {
        if (id == usuario.getId()) {
            this.usuarioRepository.delete(usuario);
        } else {
            throw new RuntimeException();
        }
    }
}
