package org.maia.procedimentosapi.repository;

import org.maia.procedimentosapi.domain.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long> {

	boolean existsByNumProcedimento (Integer numProcedimento);

	Procedimento findByNumProcedimento(Integer numProcedimento);


	
}
