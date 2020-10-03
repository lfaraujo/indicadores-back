package br.com.indicadores.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "PRODUCAO")
public class Producao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "id_funcionario")
	private Long idFuncionario;

	@Column(name = "mes_referencia")
	private String mesReferencia;

	@Column(name = "pct_mes_referencia")
	private String pctMesReferencia;

	@Column(name = "dias_escalados")
	private Integer diasEscalados;

	@Column(name = "total_geral")
	private Integer totalGeral;

	@Column(name = "instalacoes")
	private Integer instalacoes;

	@Column(name = "servicos")
	private Integer servicos;

	@Column(name = "manutencoes")
	private Integer manutencoes;

	@Column(name = "retornos")
	private Integer retornos;

	@Column(name = "total")
	private Integer total;

	@Column(name = "media_ctt_dias")
	private Integer mediaCttDias;

}
