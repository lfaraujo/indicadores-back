package br.com.indicadores.controller;

import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.indicadores.enumeration.IndicadoresCelulaEnum;
import br.com.indicadores.model.Indicador;
import br.com.indicadores.service.IndicadorService;
import br.com.indicadores.utils.ExcelUtils;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class IndicadorController {

	@Autowired
	private ExcelUtils excelUtils;

	@Autowired
	private IndicadorService indicadorService;

	private String mesReferencia;

	@PostMapping("/importar")
	public String mapearImportacaoIndicadoresExcel(@RequestParam("arquivo") MultipartFile arquivoExcel)
			throws IOException {
		
		Integer qtdRegistrosImportados = 0;

		XSSFWorkbook workbook = new XSSFWorkbook(arquivoExcel.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);

		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {

			XSSFRow row = worksheet.getRow(i);

			if (i == 1) {
				mesReferencia = excelUtils
						.obterMesAnoCelula(row.getCell(IndicadoresCelulaEnum.MES_REFERENCIA.getNumeroCelula()));
			} else if (excelUtils.isLinhaValorada(row)) {
				indicadorService.inserir(extrairIndicadorPlanilha(row));
				qtdRegistrosImportados += 1;
			}

		}

		workbook.close();

		return "Importação concluída: " + qtdRegistrosImportados + " registros processados.";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/indicador")
	public List<Indicador> obterIndicadorPorMesReferencia(@RequestHeader("mesReferencia") String mesReferencia) {
		log.info("Chamada ao método obterIndicadorPorMesReferencia...");
		return indicadorService.obterIndicadorPorMesReferencia(mesReferencia);
	}

	private Indicador extrairIndicadorPlanilha(XSSFRow row) {

		Indicador indicador = new Indicador();

		indicador.getFuncionario()
				.setLogin(excelUtils.obterStringCelula(row.getCell(IndicadoresCelulaEnum.LOGIN.getNumeroCelula())));
		indicador.getFuncionario().setNomeTecnico(
				excelUtils.obterStringCelula(row.getCell(IndicadoresCelulaEnum.NOME.getNumeroCelula())));
		indicador.getFuncionario().setUnidadeNegocio(
				excelUtils.obterStringCelula(row.getCell(IndicadoresCelulaEnum.UNIDADE_NEGOCIO.getNumeroCelula())));
		indicador.getFuncionario()
				.setCidade(excelUtils.obterStringCelula(row.getCell(IndicadoresCelulaEnum.CIDADE.getNumeroCelula())));
		indicador.getFuncionario().setFotoApp(
				excelUtils.obterBooleanoCelula(row.getCell(IndicadoresCelulaEnum.FOTO_APP.getNumeroCelula())));
		indicador.getFuncionario().setCertificadoIn(excelUtils
				.obterBooleanoCelula(row.getCell(IndicadoresCelulaEnum.TECNICO_CERTIFICADO.getNumeroCelula())));

		indicador.getProducao().setMesReferencia(mesReferencia);
		indicador.getProducao().setPctMesReferencia(excelUtils
				.obterPorcentagemCelula(row.getCell(IndicadoresCelulaEnum.PCT_MES_REFERENCIA.getNumeroCelula())));
		indicador.getProducao().setDiasEscalados(
				excelUtils.obterInteiroCelula(row.getCell(IndicadoresCelulaEnum.DIAS_ESCALADOS.getNumeroCelula())));
		indicador.getProducao().setTotalGeral(
				excelUtils.obterInteiroCelula(row.getCell(IndicadoresCelulaEnum.TOTAL_GERAL.getNumeroCelula())));
		indicador.getProducao().setInstalacoes(
				excelUtils.obterInteiroCelula(row.getCell(IndicadoresCelulaEnum.INSTALACOES.getNumeroCelula())));
		indicador.getProducao().setServicos(
				excelUtils.obterInteiroCelula(row.getCell(IndicadoresCelulaEnum.SERVICOS.getNumeroCelula())));
		indicador.getProducao().setManutencoes(
				excelUtils.obterInteiroCelula(row.getCell(IndicadoresCelulaEnum.MANUTENCAO.getNumeroCelula())));
		indicador.getProducao().setRetornos(
				excelUtils.obterInteiroCelula(row.getCell(IndicadoresCelulaEnum.RETORNO.getNumeroCelula())));
		indicador.getProducao()
				.setTotal(excelUtils.obterInteiroCelula(row.getCell(IndicadoresCelulaEnum.TOTAL.getNumeroCelula())));
		indicador.getProducao().setMediaCttDias(
				excelUtils.obterInteiroCelula(row.getCell(IndicadoresCelulaEnum.MEDIA_CTT_DIAS.getNumeroCelula())));

		indicador.getQuebra().setTotalQuebra(
				excelUtils.obterInteiroCelula(row.getCell(IndicadoresCelulaEnum.TOTAL_QUEBRA.getNumeroCelula())));
		indicador.getQuebra().setPctQuebra(
				excelUtils.obterPorcentagemCelula(row.getCell(IndicadoresCelulaEnum.PCT_QUEBRA.getNumeroCelula())));
		indicador.getQuebra().setPctAderencia(
				excelUtils.obterPorcentagemCelula(row.getCell(IndicadoresCelulaEnum.ADERENCIA.getNumeroCelula())));

		indicador.getCumprimentoAgenda()
				.setTec1(excelUtils.obterPorcentagemCelula(row.getCell(IndicadoresCelulaEnum.TEC1.getNumeroCelula())));
		indicador.getCumprimentoAgenda().setPctExecucaoSobreposta(excelUtils
				.obterPorcentagemCelula(row.getCell(IndicadoresCelulaEnum.PCT_EXEC_SOBREPOSTA.getNumeroCelula())));
		indicador.getCumprimentoAgenda().setAlteraHorarioDias(excelUtils
				.obterInteiroCelula(row.getCell(IndicadoresCelulaEnum.ALTERA_HORARIO_DIAS.getNumeroCelula())));

		indicador.getBaixa().setUsoPda(
				excelUtils.obterBooleanoCelula(row.getCell(IndicadoresCelulaEnum.USO_PDA.getNumeroCelula())));
		indicador.getBaixa()
				.setPctWa(excelUtils.obterPorcentagemCelula(row.getCell(IndicadoresCelulaEnum.WA.getNumeroCelula())));
		indicador.getBaixa()
				.setPctUra(excelUtils.obterPorcentagemCelula(row.getCell(IndicadoresCelulaEnum.URA.getNumeroCelula())));
		indicador.getBaixa().setPctHumano(
				excelUtils.obterPorcentagemCelula(row.getCell(IndicadoresCelulaEnum.HUMANO.getNumeroCelula())));

		indicador.getAtualizacaoStatusWa().setPrimeiroTrabalho(excelUtils
				.obterDuracaoCelulaString(row.getCell(IndicadoresCelulaEnum.PRIMEIRO_TRABALHO.getNumeroCelula())));
		indicador.getAtualizacaoStatusWa().setPctDeslocamento(excelUtils
				.obterPorcentagemCelula(row.getCell(IndicadoresCelulaEnum.PCT_DESLOCAMENTO.getNumeroCelula())));
		indicador.getAtualizacaoStatusWa().setPctStatusRefeicao(excelUtils
				.obterPorcentagemCelula(row.getCell(IndicadoresCelulaEnum.STATUS_REFEICAO.getNumeroCelula())));

		return indicador;
	}

}
