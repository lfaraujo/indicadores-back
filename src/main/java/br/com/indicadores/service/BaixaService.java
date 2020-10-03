package br.com.indicadores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indicadores.model.Baixa;
import br.com.indicadores.repository.BaixaRepository;

@Service
public class BaixaService {

	@Autowired
	private BaixaRepository baixaRepository;

	public Baixa inserir(Baixa baixa) {

		Baixa baixaCriada = buscarBaixaPorFuncionarioProducao(baixa.getIdFuncionario(), baixa.getIdProducao());

		if (baixaCriada != null) {
			return baixaCriada;
		}

		return baixaRepository.save(baixa);
	}

	public Baixa buscarBaixaPorFuncionarioProducao(Long idFuncionario, Long idProducao) {
		return baixaRepository.findByIdFuncionarioAndIdProducao(idFuncionario, idProducao);
	}

}
