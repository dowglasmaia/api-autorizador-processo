package org.maia.procedimentosapi.repository;

import org.maia.procedimentosapi.domain.SolicitarProcedimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitarProcedimentoRepository extends JpaRepository<SolicitarProcedimento, Long> {

	

}
