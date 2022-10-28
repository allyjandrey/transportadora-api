package br.com.uniamerica.transportadora.transportadoraapi.service;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Frete;
import br.com.uniamerica.transportadora.transportadoraapi.entity.HistoricoFrete;
import br.com.uniamerica.transportadora.transportadoraapi.entity.StatusFrete;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Usuario;
import br.com.uniamerica.transportadora.transportadoraapi.repository.HistoricoFreteRepository;
import br.com.uniamerica.transportadora.transportadoraapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoricoFreteService {

    @Autowired
    private HistoricoFreteRepository historicoFreteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<HistoricoFrete> listAll() {
        return this.historicoFreteRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void cadastrar(Frete frete, StatusFrete statusFrete) {

        final Usuario usuario = this.usuarioRepository.findById(1L).orElse(null);

        final HistoricoFrete historicoFrete = new HistoricoFrete();
        historicoFrete.setStatusFrete(statusFrete);
        historicoFrete.setData(LocalDateTime.now());
        historicoFrete.setFrete(frete);
        historicoFrete.setExecutor(usuario);

        this.historicoFreteRepository.save(historicoFrete);
    }
}
