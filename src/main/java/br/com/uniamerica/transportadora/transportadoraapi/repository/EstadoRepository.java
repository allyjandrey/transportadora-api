package br.com.uniamerica.transportadora.transportadoraapi.repository;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    public List<Estado> findByAtivoTrue();

    @Query(value = "select * from transportadora.tb_estados" +
            "where nome ilike '%' || :nome || '%' ", nativeQuery = true)
    public List<Estado> findByLikeNomeAndAtivoTrue(@Param("nome") final String nome);
}
