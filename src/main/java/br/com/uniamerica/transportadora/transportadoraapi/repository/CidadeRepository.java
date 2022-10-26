package br.com.uniamerica.transportadora.transportadoraapi.repository;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Cidade;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    public List<Cidade> findByAtivoTrue();

    public List<Cidade> findByNome (final String nome);
    public List<Cidade> findByEstado (final Estado estado);
}
