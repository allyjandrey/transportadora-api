package br.com.uniamerica.transportadora.transportadoraapi.service;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Caminhao;
import br.com.uniamerica.transportadora.transportadoraapi.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    @Transactional
    public Caminhao save(Caminhao caminhao) {
        return this.caminhaoRepository.save(caminhao);
    }

    public List<Caminhao> listAll() {
        return this.caminhaoRepository.findAll();
    }

    public Caminhao findById(Long id) {
        return this.caminhaoRepository.findById(id).orElse(new Caminhao());
    }

    @Transactional
    public void atualizar(Long id, Caminhao caminhao) {
        if (id == caminhao.getId()) {
            this.caminhaoRepository.save(caminhao);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void deletar(Long id, Caminhao caminhao) {
        if (id == caminhao.getId()) {
            this.caminhaoRepository.delete(caminhao);
        } else {
            throw new RuntimeException();
        }
    }

}