package org.maia.procedimentosapi.services.impl;

import java.util.List;


import org.maia.procedimentosapi.domain.Procedimento;
import org.maia.procedimentosapi.domain.SolicitarProcedimento;
import org.maia.procedimentosapi.domain.enums.Sexo;
import org.maia.procedimentosapi.repository.ProcedimentoRepository;
import org.maia.procedimentosapi.repository.SolicitarProcedimentoRepository;
import org.maia.procedimentosapi.services.execeptions.RequestNotAutorizationExecption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitarProcedimentoService {

    @Autowired
    private SolicitarProcedimentoRepository repository;

    @Autowired
    ProcedimentoRepository procedimentoRepo;


    public List<SolicitarProcedimento> getAll() {
        return repository.findAll();
    }

    public SolicitarProcedimento save(Integer numProcedimento, Integer idade, String sexo) {
        //Integer sexoConvert = sexo.equalsIgnoreCase("M") ? 1 : 2 ;
        boolean sexoValido = false;
        boolean idadeValido = false;

        Procedimento result = procedimentoRepo.findByNumProcedimento(numProcedimento);
        if (result == null) {
            throw new RequestNotAutorizationExecption(
                    "Procedimento ná Cadastrado na Base de Dados : Nº " + result.getNumProcedimento());
        }

        for (Sexo sex : result.getSexos()) {
            if (sex.name().equalsIgnoreCase(sexo)) {
                sexoValido = true;
                break;
            }
        }

        for (Integer i : result.getIdades()) {
            if (i.equals(idade)) {
                idadeValido = true;
                break;
            }
        }

        if (sexoValido && idadeValido) {
            SolicitarProcedimento procedimentoAutorizado = new SolicitarProcedimento(null, result, true);
           return repository.save(procedimentoAutorizado);
        } else {
            throw new RequestNotAutorizationExecption(
                    "Operação não Autorizada, Sexo e/ou Idade não aderentes ao Procedimento Solicitado.");
        }
    }

}
