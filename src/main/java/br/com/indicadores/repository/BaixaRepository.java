package br.com.indicadores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.indicadores.model.Baixa;

@Repository
public interface BaixaRepository extends JpaRepository<Baixa, Long> {

	Baixa findByIdFuncionarioAndIdProducao(Long idFuncionario, Long idProducao);

}
