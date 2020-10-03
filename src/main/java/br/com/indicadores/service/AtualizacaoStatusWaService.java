package br.com.indicadores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indicadores.model.AtualizacaoStatusWa;
import br.com.indicadores.repository.AtualizacaoStatusWaRepository;

@Service
public class AtualizacaoStatusWaService {

	@Autowired
	private AtualizacaoStatusWaRepository atualizacaoStatusWaRepository;

	public AtualizacaoStatusWa inserir(AtualizacaoStatusWa atualizacaoStatusWa) {

		AtualizacaoStatusWa atualizacaoStatusWaCriada = buscarAtualizacaoStatusWaPorFuncionarioProducao(
				atualizacaoStatusWa.getIdFuncionario(), atualizacaoStatusWa.getIdProducao());

		if (atualizacaoStatusWaCriada != null) {
			return atualizacaoStatusWaCriada;
		}

		return atualizacaoStatusWaRepository.save(atualizacaoStatusWa);
	}

	public AtualizacaoStatusWa buscarAtualizacaoStatusWaPorFuncionarioProducao(Long idFuncionario, Long idProducao) {
		return atualizacaoStatusWaRepository.findByIdFuncionarioAndIdProducao(idFuncionario, idProducao);
	}

}
