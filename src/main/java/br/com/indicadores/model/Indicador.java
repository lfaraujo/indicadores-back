package br.com.indicadores.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Indicador {

	private Funcionario funcionario;

	private Producao producao;

	private Quebra quebra;

	private CumprimentoAgenda cumprimentoAgenda;

	private Baixa baixa;

	private AtualizacaoStatusWa atualizacaoStatusWa;

	public Indicador() {
		this.funcionario = new Funcionario();
		this.producao = new Producao();
		this.quebra = new Quebra();
		this.cumprimentoAgenda = new CumprimentoAgenda();
		this.baixa = new Baixa();
		this.atualizacaoStatusWa = new AtualizacaoStatusWa();
	}

}
