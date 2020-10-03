package br.com.indicadores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.indicadores.model.AtualizacaoStatusWa;

@Repository
public interface AtualizacaoStatusWaRepository extends JpaRepository<AtualizacaoStatusWa, Long> {

	AtualizacaoStatusWa findByIdFuncionarioAndIdProducao(Long idFuncionario, Long idProducao);

}
