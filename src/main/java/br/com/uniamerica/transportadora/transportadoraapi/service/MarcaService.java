package br.com.uniamerica.transportadora.transportadoraapi.service;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Marca;
import br.com.uniamerica.transportadora.transportadoraapi.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Transactional
    public Marca save(Marca marca) {
        return this.marcaRepository.save(marca);
    }

    public List<Marca> listAll() {
        return this.marcaRepository.findAll();
    }

    public Marca findById(Long id) {
        return this.marcaRepository.findById(id).orElse(new Marca());
    }

    @Transactional
    public void update(Long id, Marca marca) {
        if(id == marca.getId()) {
            this.marcaRepository.save(marca);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void delete(Long id, Marca marca) {
        if(id == marca.getId()) {
            this.marcaRepository.delete(marca);
        } else {
            throw new RuntimeException();
        }
    }
}
