package br.com.uniamerica.transportadora.transportadoraapi.repository;

import br.com.uniamerica.transportadora.transportadoraapi.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    public List<Despesa> findByAtivoTrue();

    @Query(value = "select * from transportadora.tb_despesas" +
            "where nome ilike '%' || :nome || '%' ", nativeQuery = true)
    public List<Despesa> findByLikeNomeAndAtivoTrue(@Param("nome")final String nome);

    public List<Despesa> findByTipoDespesa (final TipoDespesa tipoDespesa);

    public List<Despesa> findByValor (final BigDecimal valor);

    public List<Despesa> findByMotorista (final Usuario motorista);

    public List<Despesa> findByData (final LocalDateTime data);

    public List<Despesa> findByAprovador (final Usuario aprovador);

    public List<Despesa> findByFrete (final Frete frete);
}
