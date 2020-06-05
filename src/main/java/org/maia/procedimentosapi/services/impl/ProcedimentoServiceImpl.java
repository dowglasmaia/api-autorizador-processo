package org.maia.procedimentosapi.services.impl;

import java.util.List;
import java.util.Optional;

import org.maia.procedimentosapi.domain.Procedimento;
import org.maia.procedimentosapi.repository.ProcedimentoRepository;
import org.maia.procedimentosapi.services.execeptions.RequestNotAutorizationExecption;
import org.maia.procedimentosapi.services.interfaces.ProcedimentoService;
import org.springframework.stereotype.Service;

@Service
public class ProcedimentoServiceImpl implements ProcedimentoService {

	private ProcedimentoRepository repository;

	public ProcedimentoServiceImpl(ProcedimentoRepository repository) {
		this.repository = repository;
	}

	@Override
	public Procedimento save(Procedimento obj) {
		Procedimento procedimento = getByNumProcedimento(obj.getNumProcedimento());
		if (procedimento != null) {
			throw new RequestNotAutorizationExecption(
					"Procedimento já Cadastrado na Base de Dados : Nº " + obj.getNumProcedimento());
		}
		Procedimento newProcedimento = repository.save(obj);
		return newProcedimento;
	}

	@Override
	public Procedimento getById(Long id) {
		Optional<Procedimento> result = repository.findById(id);
		return result.orElseThrow(() -> new RuntimeException("Procedimento não encontrapara para o ID: " + id));
	}

	@Override
	public List<Procedimento> getAll() {
		return repository.findAll();
	}

	@Override
	public Procedimento getByNumProcedimento(Integer numProcedimento) {
		return  repository.findByNumProcedimento(numProcedimento);
	}

}
