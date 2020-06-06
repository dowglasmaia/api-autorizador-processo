package org.maia.procedimentosapi.resources;

import java.util.List;

import org.maia.procedimentosapi.domain.SolicitarProcedimento;
import org.maia.procedimentosapi.services.impl.SolicitarProcedimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autorizadores")
public class SolicitarProcedimentoResources {

	@Autowired
	private SolicitarProcedimentoService service;

	@PostMapping("/{numProcedimento}")
	public ResponseEntity<Void> solicitaProcedimento(@PathVariable Integer numProcedimento,
			@RequestParam(value = "idade") Integer idade, @RequestParam(value = "sexo") String sexo) {
		SolicitarProcedimento solicitacao = service.save(numProcedimento, idade, sexo);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<SolicitarProcedimento>> getAll() {
		List<SolicitarProcedimento> result = service.getAll();
		return ResponseEntity.ok().body(result);
	}

}
