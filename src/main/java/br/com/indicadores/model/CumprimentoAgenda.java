package br.com.indicadores.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "CUMPRIMENTO_AGENDA")
public class CumprimentoAgenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idFuncionario;

	private Long idProducao;

	private String tec1;

	private String pctExecucaoSobreposta;

	private Integer alteraHorarioDias;

}
