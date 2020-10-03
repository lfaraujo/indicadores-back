package br.com.indicadores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indicadores.model.Quebra;
import br.com.indicadores.repository.QuebraRepository;

@Service
public class QuebraService {

	@Autowired
	private QuebraRepository quebraRepository;

	public Quebra inserir(Quebra quebra) {

		Quebra quebraCriada = buscarQuebraPorFuncionarioProducao(quebra.getIdFuncionario(), quebra.getIdProducao());
		
		if (quebraCriada != null) {
			return quebraCriada;
		}
		
		return quebraRepository.save(quebra);
	}
	
	public Quebra buscarQuebraPorFuncionarioProducao(Long idFuncionario, Long idProducao) {
		return quebraRepository.findByIdFuncionarioAndIdProducao(idFuncionario, idProducao);
	}

}
