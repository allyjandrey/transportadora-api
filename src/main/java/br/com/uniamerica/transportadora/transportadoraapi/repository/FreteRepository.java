package br.com.uniamerica.transportadora.transportadoraapi.repository;

import br.com.uniamerica.transportadora.transportadoraapi.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FreteRepository extends JpaRepository<FreteRepository, Long> {

    public List<Frete> findByAtivoTrue();

    public List<Frete> findByProduto (final Produto produto);

    public List<Frete> findByCidadeOrigem (final Cidade cidadeOrigem);

    public List<Frete> findByCidadeDestino (final Cidade cidadeDestino);

    public List<Frete> findByMotorista (final Usuario motorista);

    public List<Frete> findByCaminhao (final Caminhao caminhao);

    public List<Frete> findByQuilometragemIni (final int quilometragemIni);

    public List<Frete> findByQuilometragemFim (final int quilometragemFim);

    public List<Frete> findByTotalBruto (final BigDecimal totalBruto);

    public List<Frete> findByTotalLiquido (final BigDecimal totalLiquido);

    public List<Frete> findByPesoInicial (final BigDecimal pesoInicial);

    public List<Frete> findByPesoFinal (final BigDecimal pesoFinal);

    public List<Frete> findByPesoFinalTransportado (final BigDecimal pesoFinalTransportado);

    public List<Frete> findByPrecoTonelada (final BigDecimal pesoTonelada);
}
