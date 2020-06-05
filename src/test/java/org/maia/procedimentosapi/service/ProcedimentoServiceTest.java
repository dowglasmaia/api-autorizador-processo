package org.maia.procedimentosapi.service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.maia.procedimentosapi.domain.Procedimento;
import org.maia.procedimentosapi.domain.enums.Sexo;
import org.maia.procedimentosapi.services.interfaces.ProcedimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("tests")
@SpringBootTest
public class ProcedimentoServiceTest {

    @Autowired
    ProcedimentoService service;

    @Test
    @DisplayName("Deve Salvar um Novo Procedimento")
    public void saveProcedimentoTest(){
        Procedimento newObj = new Procedimento(null,12345);
        newObj.addSexo(Sexo.F);
        newObj.getIdades().add(20);

        Procedimento procedimentoSaved = service.save(newObj);

        assertThat(procedimentoSaved.getId()).isNotNull();
        assertThat(procedimentoSaved.getNumProcedimento()).isEqualTo(12345);
    }

    @Test
    @DisplayName("Deve retorna uma lista de Procedimentos salvos na base dados")
    public void getAllProcedimentos(){
        List<Procedimento>result = service.getAll();

        assertThat(result).isNotEmpty();
    }

}
