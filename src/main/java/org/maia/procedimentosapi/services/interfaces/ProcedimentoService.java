package org.maia.procedimentosapi.services.interfaces;

import java.util.List;

import org.maia.procedimentosapi.domain.Procedimento;
import org.springframework.transaction.annotation.Transactional;

public interface ProcedimentoService {

	@Transactional(readOnly = false)
	Procedimento save(Procedimento obj);

	@Transactional(readOnly = true)
	Procedimento getById(Long id);

	@Transactional(readOnly = true)
	List<Procedimento> getAll();

	@Transactional(readOnly = true)
	Procedimento getByNumProcedimento(Integer numProcedimento);

}
