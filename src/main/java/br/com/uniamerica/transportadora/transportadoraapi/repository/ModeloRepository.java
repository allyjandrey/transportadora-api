package br.com.uniamerica.transportadora.transportadoraapi.repository;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Marca;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    public List<Modelo> findByAtivoTrue();

    public List<Modelo> findByNome (final String nome);

    public List<Modelo> findByMarca (final Marca marca);
}
