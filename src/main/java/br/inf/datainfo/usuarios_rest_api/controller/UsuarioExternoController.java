package br.inf.datainfo.usuarios_rest_api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.inf.datainfo.usuarios_rest_api.dao.UsuarioExternoDAO;
import br.inf.datainfo.usuarios_rest_api.model.UsuarioExterno;

@RestController
@RequestMapping("/datainfo")
public class UsuarioExternoController {

	@Autowired
	UsuarioExternoDAO usuarioExternoDAO;

	@PostMapping("/usuarios")
	public UsuarioExterno criarUsuario(@Valid @RequestBody UsuarioExterno usuarioExterno) {
		return usuarioExternoDAO.salvar(usuarioExterno);
	}

	@GetMapping("/usuarios")
	public List<UsuarioExterno> listarTodosUsuarios(@RequestParam(value = "nome", required = false) String nome, @RequestParam(value = "situacao", required = false) String situacao, @RequestParam(value = "perfil", required = false) Long perfil) {
		return usuarioExternoDAO.listar(nome, situacao, perfil);
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<UsuarioExterno> listarUsuarioPeloId(@PathVariable(value = "id") Long usuarioExternoId) {
		UsuarioExterno usuarioExterno = usuarioExternoDAO.listarPeloId(usuarioExternoId);

		if (usuarioExterno == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(usuarioExterno);
	}

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<UsuarioExterno> atualizarUsuario(@PathVariable(value = "id") Long usuarioExternoId, @Valid @RequestBody UsuarioExterno usuarioExterno) {
		UsuarioExterno usuarioExternoAtualizar = usuarioExternoDAO.listarPeloId(usuarioExternoId);

		if (usuarioExternoAtualizar == null) {
			return ResponseEntity.notFound().build();
		}

		usuarioExternoAtualizar.setCpf(usuarioExterno.getCpf());
		usuarioExternoAtualizar.setUsuario(usuarioExterno.getUsuario());
		usuarioExternoAtualizar.setEmail(usuarioExterno.getEmail());
		usuarioExternoAtualizar.setSituacao(usuarioExterno.getSituacao());
		usuarioExternoAtualizar.setPerfilAcesso(usuarioExterno.getPerfilAcesso());
		usuarioExternoAtualizar.setFuncaoId(usuarioExterno.getFuncaoId());
		usuarioExternoAtualizar.setTelefone(usuarioExterno.getTelefone());

		UsuarioExterno usuarioExternoAtualizado = usuarioExternoDAO.salvar(usuarioExternoAtualizar);
		return ResponseEntity.ok().body(usuarioExternoAtualizado);
	}

	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<UsuarioExterno> deletarUsuario(@PathVariable(value = "id") Long usuarioExternoId) {
		UsuarioExterno usuarioExterno = usuarioExternoDAO.listarPeloId(usuarioExternoId);

		if (usuarioExterno == null) {
			return ResponseEntity.notFound().build();
		}

		usuarioExternoDAO.deletar(usuarioExterno);
		return ResponseEntity.ok().build();
	}

}
