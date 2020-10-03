package br.com.indicadores.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class IndicadorRowMapper implements RowMapper<Indicador> {

	@Override
	public Indicador mapRow(ResultSet rs, int rowNum) throws SQLException {

		Indicador indicador = new Indicador();
		indicador.getFuncionario().setLogin(rs.getString("login"));
		indicador.getFuncionario().setNomeTecnico(rs.getString("nome_tecnico"));
		indicador.getFuncionario().setUnidadeNegocio(rs.getString("unidade_negocio"));
		indicador.getFuncionario().setCidade(rs.getString("cidade"));
		indicador.getFuncionario().setFotoApp(rs.getBoolean("foto_app"));
		
		if (rs.wasNull()) {
			indicador.getFuncionario().setFotoApp(null);
		}
		
		indicador.getFuncionario().setCertificadoIn(rs.getBoolean("certificado_in"));
		
		if (rs.wasNull()) {
			indicador.getFuncionario().setCertificadoIn(null);
		}

		indicador.getProducao().setMesReferencia(rs.getString("mes_referencia"));
		indicador.getProducao().setPctMesReferencia(rs.getString("pct_mes_referencia"));
		indicador.getProducao().setDiasEscalados(rs.getInt("dias_escalados"));
		indicador.getProducao().setTotalGeral(rs.getInt("total_geral"));
		indicador.getProducao().setInstalacoes(rs.getInt("instalacoes"));
		indicador.getProducao().setServicos(rs.getInt("servicos"));
		indicador.getProducao().setManutencoes(rs.getInt("manutencoes"));
		indicador.getProducao().setRetornos(rs.getInt("retornos"));
		indicador.getProducao().setTotal(rs.getInt("total"));
		indicador.getProducao().setMediaCttDias(rs.getInt("media_ctt_dias"));

		indicador.getQuebra().setTotalQuebra(rs.getInt("total_quebra"));
		indicador.getQuebra().setPctQuebra(rs.getString("pct_quebra"));
		indicador.getQuebra().setPctAderencia(rs.getString("pct_aderencia"));

		indicador.getCumprimentoAgenda().setTec1(rs.getString("tec1"));
		indicador.getCumprimentoAgenda().setPctExecucaoSobreposta(rs.getString("pct_execucao_sobreposta"));
		indicador.getCumprimentoAgenda().setAlteraHorarioDias(rs.getInt("altera_horario_dias"));

		indicador.getBaixa().setUsoPda(rs.getBoolean("uso_pda"));
		
		if (rs.wasNull()) {
			indicador.getBaixa().setUsoPda(null);
		}
		
		indicador.getBaixa().setPctWa(rs.getString("pct_wa"));
		indicador.getBaixa().setPctUra(rs.getString("pct_ura"));
		indicador.getBaixa().setPctHumano(rs.getString("pct_humano"));

		indicador.getAtualizacaoStatusWa().setPrimeiroTrabalho(rs.getString("primeiro_trabalho"));
		indicador.getAtualizacaoStatusWa().setPctDeslocamento(rs.getString("pct_deslocamento"));
		indicador.getAtualizacaoStatusWa().setPctStatusRefeicao(rs.getString("pct_status_refeicao"));

		return indicador;
	}

}
