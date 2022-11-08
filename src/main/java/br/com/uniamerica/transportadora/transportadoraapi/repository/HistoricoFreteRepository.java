package br.com.uniamerica.transportadora.transportadoraapi.repository;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Frete;
import br.com.uniamerica.transportadora.transportadoraapi.entity.HistoricoFrete;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HistoricoFreteRepository extends JpaRepository<HistoricoFrete, Long> {

    public List<HistoricoFrete> findByAtivoTrue();

    @Query("from HistoricoFrete historicoFrete where.frete.id = :freteId")
    public List<HistoricoFrete> findByFrete(@Param("freteId") Long freteId);

    public List<HistoricoFrete> findByData(final LocalDate data);

    public List<HistoricoFrete> findByFrete(final Frete frete);

    public List<HistoricoFrete> findByExecutor(final Usuario executor);

}
