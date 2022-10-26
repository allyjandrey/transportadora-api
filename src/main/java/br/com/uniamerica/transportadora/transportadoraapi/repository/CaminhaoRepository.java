package br.com.uniamerica.transportadora.transportadoraapi.repository;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Caminhao;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Cor;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {

    public List<Caminhao> findByAtivoTrue();

    public List<Caminhao> findByPlaca (final String placa);

    public List<Caminhao> findByModelo (final Modelo modelo);

    public List<Caminhao> findByAno (final int ano);

    public List<Caminhao> findByCor (final Cor cor);
}
