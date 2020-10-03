package br.com.indicadores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.indicadores.model.Quebra;

@Repository
public interface QuebraRepository extends JpaRepository<Quebra, Long> {

	Quebra findByIdFuncionarioAndIdProducao(Long idFuncionario, Long idProducao);

}
