package br.com.indicadores.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ATUALIZACAO_STATUS_WA")
public class AtualizacaoStatusWa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idFuncionario;

	private Long idProducao;

	private String primeiroTrabalho;

	private String pctDeslocamento;

	private String pctStatusRefeicao;

}
