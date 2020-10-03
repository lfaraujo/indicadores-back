package br.com.indicadores.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indicadores.model.Indicador;
import br.com.indicadores.repository.IndicadorDao;

@Service
public class IndicadorService {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private ProducaoService producaoService;

	@Autowired
	private QuebraService quebraService;

	@Autowired
	private CumprimentoAgendaService cumprimentoAgendaService;

	@Autowired
	private BaixaService baixaService;

	@Autowired
	private AtualizacaoStatusWaService atualizacaoStatusWaService;

	@Autowired
	private IndicadorDao indicadorDao;

	public void inserir(Indicador indicador) {

		Long idFuncionario = funcionarioService.inserir(indicador.getFuncionario()).getId();

		indicador.getProducao().setIdFuncionario(idFuncionario);

		Long idProducao = producaoService.inserir(indicador.getProducao()).getId();

		indicador.getQuebra().setIdFuncionario(idFuncionario);
		indicador.getQuebra().setIdProducao(idProducao);

		quebraService.inserir(indicador.getQuebra());

		indicador.getCumprimentoAgenda().setIdFuncionario(idFuncionario);
		indicador.getCumprimentoAgenda().setIdProducao(idProducao);

		cumprimentoAgendaService.inserir(indicador.getCumprimentoAgenda());

		indicador.getBaixa().setIdFuncionario(idFuncionario);
		indicador.getBaixa().setIdProducao(idProducao);

		baixaService.inserir(indicador.getBaixa());

		indicador.getAtualizacaoStatusWa().setIdFuncionario(idFuncionario);
		indicador.getAtualizacaoStatusWa().setIdProducao(idProducao);

		atualizacaoStatusWaService.inserir(indicador.getAtualizacaoStatusWa());

	}

	public List<Indicador> obterIndicadorPorMesReferencia(String mesReferencia) {
		return indicadorDao.buscarIndicadorPorMesReferencia(mesReferencia);
	}

}
