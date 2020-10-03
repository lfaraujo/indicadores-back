package br.com.indicadores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.indicadores.model.Producao;

@Repository
public interface ProducaoRepository extends JpaRepository<Producao, Long> {

	Producao findByIdFuncionarioAndMesReferencia(Long idFuncionario, String mesReferencia);

}
