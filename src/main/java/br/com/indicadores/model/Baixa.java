package br.com.indicadores.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "BAIXA")
public class Baixa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idFuncionario;

	private Long idProducao;

	private Boolean usoPda;

	private String pctWa;

	private String pctUra;

	private String pctHumano;

}
