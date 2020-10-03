package br.com.indicadores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.indicadores.model.Usuario;
import br.com.indicadores.service.UsuarioService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios() {
		return usuarioService.listarUsuarios();
	}
}
