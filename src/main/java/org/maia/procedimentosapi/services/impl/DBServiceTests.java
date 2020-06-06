package org.maia.procedimentosapi.services.impl;

import java.text.ParseException;
import java.util.Arrays;

import org.maia.procedimentosapi.domain.Procedimento;
import org.maia.procedimentosapi.domain.enums.Sexo;
import org.maia.procedimentosapi.repository.ProcedimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** @author Dowglas Maia
 * @since Class responsavel por testar a integração com base dados.
 * */

@Service
public class DBServiceTests {
	
	
	@Autowired
	ProcedimentoRepository proRepo;
	
	public void instanciateTestDatabase() throws ParseException {
		
		Procedimento p1 = new Procedimento(null, 1234);		
		p1.getIdades().addAll(Arrays.asList(10,20));
		p1.addSexo(Sexo.F);

		Procedimento p2 = new Procedimento(null, 4567);
		p2.getIdades().addAll(Arrays.asList(20,30));
		p2.addSexo(Sexo.F);
		p2.addSexo(Sexo.M);

		Procedimento p3 = new Procedimento(null, 6789);	
		p3.getIdades().addAll(Arrays.asList(10));
		p3.addSexo(Sexo.F);
		p3.addSexo(Sexo.M);

		proRepo.saveAll(Arrays.asList(p1, p2, p3));
	}

}
