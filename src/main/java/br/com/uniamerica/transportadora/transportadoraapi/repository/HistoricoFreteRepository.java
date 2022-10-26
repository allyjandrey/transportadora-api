package br.com.uniamerica.transportadora.transportadoraapi.repository;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Frete;
import br.com.uniamerica.transportadora.transportadoraapi.entity.HistoricoFrete;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HistoricoFreteRepository extends JpaRepository<HistoricoFreteRepository, Long> {

    public List<HistoricoFrete> findByAtivoTrue();

    public List<HistoricoFrete> findByData (final LocalDate data);

    public List<HistoricoFrete> findByFrete (final Frete frete);

    public List<HistoricoFrete> findByExecutor (final Usuario executor);
}
