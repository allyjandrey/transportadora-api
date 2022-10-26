package br.com.uniamerica.transportadora.transportadoraapi.repository;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Despesa;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Frete;
import br.com.uniamerica.transportadora.transportadoraapi.entity.TipoDespesa;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DespesaRepository extends JpaRepository<DespesaRepository, Long> {

    public List<Despesa> findByAtivoTrue();

    public List<Despesa> findByTipoDespesa (final TipoDespesa tipoDespesa);

    public List<Despesa> findByValor (final BigDecimal valor);

    public List<Despesa> findByMotorista (final Usuario motorista);

    public List<Despesa> findByData (final LocalDateTime data);

    public List<Despesa> findByAprovador (final Usuario aprovador);

    public List<Despesa> findByFrete (final Frete frete);
}
