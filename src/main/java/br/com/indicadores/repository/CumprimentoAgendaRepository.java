package br.com.indicadores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.indicadores.model.CumprimentoAgenda;

@Repository
public interface CumprimentoAgendaRepository extends JpaRepository<CumprimentoAgenda, Long> {

	CumprimentoAgenda findByIdFuncionarioAndIdProducao(Long idFuncionario, Long idProducao);

}
