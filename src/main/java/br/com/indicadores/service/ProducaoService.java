package br.com.indicadores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indicadores.model.Producao;
import br.com.indicadores.repository.ProducaoRepository;

@Service
public class ProducaoService {

	@Autowired
	private ProducaoRepository producaoRepository;

	public Producao inserir(Producao producao) {
		
		Producao producaoCriada = buscarProducaoPorFuncionarioMesReferencia(producao.getIdFuncionario(), producao.getMesReferencia());
		
		if (producaoCriada != null) {
			return producaoCriada;
		}
		
		return producaoRepository.save(producao);
	}
	
	public Producao buscarProducaoPorFuncionarioMesReferencia(Long idFuncionario, String mesReferencia) {
		return producaoRepository.findByIdFuncionarioAndMesReferencia(idFuncionario, mesReferencia);
	}
}
