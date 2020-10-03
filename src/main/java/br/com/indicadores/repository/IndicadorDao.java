package br.com.indicadores.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.com.indicadores.model.Indicador;
import br.com.indicadores.model.IndicadorRowMapper;

@Component
public class IndicadorDao {

	private static final String SQL_BUSCAR_INDICADOR = "SELECT F.login, F.nome_tecnico, F.unidade_negocio, F.cidade, P.mes_referencia, P.pct_mes_referencia, P.dias_escalados, "
			+ "P.total_geral, P.instalacoes, P.servicos, P.manutencoes, P.retornos, P.total, P.media_ctt_dias, Q.total_quebra, Q.pct_quebra, Q.pct_aderencia, CA.tec1, "
			+ "CA.pct_execucao_sobreposta, CA.altera_horario_dias, B.uso_pda, B.pct_wa, B.pct_ura, B.pct_humano, ASW.primeiro_trabalho, ASW.pct_deslocamento, "
			+ "ASW.pct_status_refeicao, F.foto_app, F.certificado_in " + "FROM FUNCIONARIO F "
			+ "INNER JOIN PRODUCAO P ON F.id = P.id_funcionario " + "INNER JOIN QUEBRA Q on F.id = Q.id_funcionario "
			+ "INNER JOIN CUMPRIMENTO_AGENDA CA on F.id = CA.id_funcionario "
			+ "INNER JOIN BAIXA B on F.id = B.id_funcionario "
			+ "INNER JOIN ATUALIZACAO_STATUS_WA ASW on F.id = ASW.id_funcionario " 
			+ "WHERE P.mes_referencia = ";

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	public IndicadorDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Indicador> buscarIndicadorPorMesReferencia(String mesReferencia) {
		return jdbcTemplate.query(SQL_BUSCAR_INDICADOR + "'" + mesReferencia + "'", new IndicadorRowMapper());
	}

}
