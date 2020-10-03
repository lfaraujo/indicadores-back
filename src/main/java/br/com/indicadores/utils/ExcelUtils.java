package br.com.indicadores.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.springframework.stereotype.Component;

@Component
public class ExcelUtils {

	public String obterStringCelula(XSSFCell celula) {

		if (celula.getCellType().equals(CellType.BLANK)) {
			return null;
		} else if (celula.getCellType().equals(CellType.STRING)) {
			return extrairValorStringVazia(celula.getStringCellValue());
		}

		return null;
	}

	public Integer obterInteiroCelula(XSSFCell celula) {

		if (celula.getCellType().equals(CellType.BLANK)) {
			return null;
		} else if (celula.getCellType().equals(CellType.NUMERIC)) {
			return (int) celula.getNumericCellValue();
		}

		return null;
	}

	public Boolean obterBooleanoCelula(XSSFCell celula) {

		if (celula.getCellType().equals(CellType.BLANK)) {
			return null;
		} else if (celula.getCellType().equals(CellType.STRING)) {
			return extrairValorBooleanoString(celula.getStringCellValue());
		} else if (celula.getCellType().equals(CellType.BOOLEAN)) {
			return celula.getBooleanCellValue();
		}

		return null;
	}

	public String obterDuracaoCelulaString(XSSFCell celula) {

		if (celula.getCellType().equals(CellType.BLANK)) {
			return null;
		} else if (celula.getCellType().equals(CellType.NUMERIC)) {
			return celula.getLocalDateTimeCellValue().toLocalTime().toString();
		}

		return null;
	}

	public String obterPorcentagemCelula(XSSFCell celula) {

		if (celula.getCellType().equals(CellType.BLANK)) {
			return null;
		} else if (celula.getCellType().equals(CellType.STRING)) {
			return extrairValorStringVazia(celula.getStringCellValue());
		} else if (celula.getCellType().equals(CellType.NUMERIC)) {
			return extrairStringPorcentagem(celula.getNumericCellValue());
		}

		return null;
	}

	public String obterMesAnoCelula(XSSFCell celula) {

		if (celula.getCellType().equals(CellType.BLANK)) {
			return null;
		} else if (celula.getCellType().equals(CellType.STRING)) {
			return celula.getStringCellValue().replace("-", "/");
		}

		return null;
	}

	public boolean isLinhaValorada(XSSFRow linha) {

		if (linha == null) {
			return false;
		}

		if (linha.getLastCellNum() <= 0) {
			return false;
		}

		for (int cellNum = linha.getFirstCellNum(); cellNum < linha.getLastCellNum(); cellNum++) {

			Cell cell = linha.getCell(cellNum);

			if (cell != null && !cell.getCellType().equals(CellType.BLANK) && StringUtils.isNotBlank(cell.toString())) {
				return true;
			}

		}

		return false;
	}

	private Boolean extrairValorBooleanoString(String valorCelula) {

		if (valorCelula.equalsIgnoreCase("SIM")) {
			return Boolean.TRUE;
		} else if (valorCelula.equalsIgnoreCase("NAO") || valorCelula.equalsIgnoreCase("NÃO")) {
			return Boolean.FALSE;
		}

		return null;
	}

	private String extrairStringPorcentagem(Double valorPorcentagem) {

		if (valorPorcentagem < 1.0) {
			return valorPorcentagem.toString().replace("0.", "") + "%";
		}

		return valorPorcentagem.toString().replace(".0", "00") + "%";
	}

	private String extrairValorStringVazia(String valorCelula) {

		if (valorCelula.equals("-")) {
			return null;
		}

		return valorCelula;
	}

}
