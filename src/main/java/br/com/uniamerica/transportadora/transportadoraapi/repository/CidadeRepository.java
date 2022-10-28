package br.com.uniamerica.transportadora.transportadoraapi.repository;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Cidade;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    public List<Cidade> findByAtivoTrue();

    @Query("from Estado estado where.estado.id = :estadoId")

    public List<Cidade> findByEstado(@Param("estadoId") Long estadoId);

    public List<Cidade> findByNome(final String nome);

    public List<Cidade> findByEstado(final Estado estado);
}
