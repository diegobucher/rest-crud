package br.inf.datainfo.usuarios_rest_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.inf.datainfo.usuarios_rest_api.model.UsuarioExterno;

public interface UsuarioExternoRepository extends JpaRepository<UsuarioExterno, Long> {

	@Query(value = "select * from usuario_externo u where upper(u.usuario) like upper(?) and u.situacao = ? and u.perfil_acesso = ?", nativeQuery = true)
	List<UsuarioExterno> listarComParametros(String nome, String situacao, Long perfil);

}
