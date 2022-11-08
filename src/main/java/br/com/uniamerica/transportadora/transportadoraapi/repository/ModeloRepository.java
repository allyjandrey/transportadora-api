package br.com.uniamerica.transportadora.transportadoraapi.repository;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Marca;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    @Query("from Modelo modelo where.marca.id = :marcaId")
    public List<Modelo> findByMarca(@Param("marcaId") Long marcaId);

    public List<Modelo> findByAtivoTrue();

    public List<Modelo> findByNome(final String nome);

    public List<Modelo> findByMarca(final Marca marca);
}
