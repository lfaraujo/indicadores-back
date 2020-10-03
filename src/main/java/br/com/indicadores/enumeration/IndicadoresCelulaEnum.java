package br.com.indicadores.enumeration;

import lombok.Getter;

@Getter
public enum IndicadoresCelulaEnum {

	LOGIN(0), NOME(1), UNIDADE_NEGOCIO(2), CIDADE(3), MES_REFERENCIA(4), PCT_MES_REFERENCIA(4), DIAS_ESCALADOS(5),
	TOTAL_GERAL(6), INSTALACOES(7), SERVICOS(8), MANUTENCAO(9), RETORNO(10), TOTAL(11), MEDIA_CTT_DIAS(12),
	TOTAL_QUEBRA(13), PCT_QUEBRA(14), ADERENCIA(15), TEC1(16), PCT_EXEC_SOBREPOSTA(17), ALTERA_HORARIO_DIAS(18),
	USO_PDA(19), WA(20), URA(21), HUMANO(22), PRIMEIRO_TRABALHO(23), PCT_DESLOCAMENTO(24), STATUS_REFEICAO(25),
	FOTO_APP(26), TECNICO_CERTIFICADO(27);

	private Integer numeroCelula;

	private IndicadoresCelulaEnum(Integer celula) {
		this.numeroCelula = celula;
	}

}
