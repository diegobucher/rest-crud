package br.inf.datainfo.usuarios_rest_api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inf.datainfo.usuarios_rest_api.model.UsuarioExterno;
import br.inf.datainfo.usuarios_rest_api.repository.UsuarioExternoRepository;

@Service
public class UsuarioExternoDAO {

	@Autowired
	UsuarioExternoRepository usuarioExternoRepository;

	public UsuarioExterno salvar(UsuarioExterno usuarioExterno) {
		return usuarioExternoRepository.save(usuarioExterno);
	}

	public List<UsuarioExterno> listar(String nome, String situacao, Long perfil) {
		if (!nome.isEmpty() || !situacao.isEmpty() || perfil != null) {
			return usuarioExternoRepository.listarComParametros(nome, situacao, perfil);
		} else {
			return usuarioExternoRepository.findAll();
		}
	}

	public UsuarioExterno listarPeloId(Long usuarioExternoId) {
		return usuarioExternoRepository.findOne(usuarioExternoId);
	}

	public void deletar(UsuarioExterno usuarioExterno) {
		usuarioExternoRepository.delete(usuarioExterno);
	}

}
