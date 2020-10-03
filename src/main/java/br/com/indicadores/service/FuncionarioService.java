package br.com.indicadores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indicadores.model.Funcionario;
import br.com.indicadores.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario inserir(Funcionario funcionario) {

		Funcionario funcionarioCriado = buscarFuncionarioPorLogin(funcionario.getLogin());

		if (funcionarioCriado != null) {
			return funcionarioCriado;
		}

		return funcionarioRepository.save(funcionario);
	}

	public Funcionario buscarFuncionarioPorLogin(String login) {
		return funcionarioRepository.findByLogin(login);
	}

}
