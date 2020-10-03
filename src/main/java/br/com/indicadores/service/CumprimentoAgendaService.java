package br.com.indicadores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indicadores.model.CumprimentoAgenda;
import br.com.indicadores.repository.CumprimentoAgendaRepository;

@Service
public class CumprimentoAgendaService {

	@Autowired
	private CumprimentoAgendaRepository cumprimentoAgendaRepository;

	public CumprimentoAgenda inserir(CumprimentoAgenda cumprimentoAgenda) {

		CumprimentoAgenda cumprimentoAgendaCriado = buscarCumprimentoAgendaPorFuncionarioProducao(
				cumprimentoAgenda.getIdFuncionario(), cumprimentoAgenda.getIdProducao());

		if (cumprimentoAgendaCriado != null) {
			return cumprimentoAgendaCriado;
		}

		return cumprimentoAgendaRepository.save(cumprimentoAgenda);
	}

	public CumprimentoAgenda buscarCumprimentoAgendaPorFuncionarioProducao(Long idFuncionario, Long idProducao) {
		return cumprimentoAgendaRepository.findByIdFuncionarioAndIdProducao(idFuncionario, idProducao);
	}

}
