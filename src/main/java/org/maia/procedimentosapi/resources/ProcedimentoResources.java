package org.maia.procedimentosapi.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.maia.procedimentosapi.domain.Procedimento;
import org.maia.procedimentosapi.services.impl.ProcedimentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/procedimentos")
public class ProcedimentoResources {

	@Autowired
	private ProcedimentoServiceImpl service;

	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody Procedimento obj) {
		Procedimento procedimento = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(procedimento.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	public ResponseEntity<List<Procedimento>> getAll() {
		List<Procedimento> result = service.getAll();
		return ResponseEntity.ok().body(result);
	}

}
