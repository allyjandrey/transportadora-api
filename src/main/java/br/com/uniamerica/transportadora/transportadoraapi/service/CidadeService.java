package br.com.uniamerica.transportadora.transportadoraapi.service;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Cidade;
import br.com.uniamerica.transportadora.transportadoraapi.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional
    public Cidade save(Cidade cidade) {
        return this.cidadeRepository.save(cidade);
    }

    public List<Cidade> listAll() {
        return this.cidadeRepository.findAll();
    }

    public Cidade findById(Long id) {
        return this.cidadeRepository.findById(id).orElse(new Cidade());
    }

    @Transactional
    public void update(Long id, Cidade cidade) {
        if(id == cidade.getId()) {
            this.cidadeRepository.save(cidade);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void delete(Long id, Cidade cidade) {
        if(id == cidade.getId()) {
            this.cidadeRepository.delete(cidade);
        } else {
            throw new RuntimeException();
        }
    }
}
