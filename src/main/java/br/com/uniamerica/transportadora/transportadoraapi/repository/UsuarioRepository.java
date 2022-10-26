package br.com.uniamerica.transportadora.transportadoraapi.repository;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Grupo;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioRepository, Long> {

    public List<Usuario> findByAtivoTrue();

    public List<Usuario> findByLogin (final String login);

    public List<Usuario> findByGrupo (final Grupo grupo);

    public List<Usuario> findByNome (final String nome);

    public List<Usuario> findByCPF (final String cpf);

    public List<Usuario> findByTelefone (final int telefone);

    public List<Usuario> findByEndereco (final String endereco);
}
