package br.com.uniamerica.transportadora.transportadoraapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoFreteRepository extends JpaRepository<HistoricoFreteRepository, Long> {
}
