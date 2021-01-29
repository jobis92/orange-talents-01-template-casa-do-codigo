package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.controller.form.EstadoForm;
import br.com.zup.casadocodigo.modelo.Estado;

@RestController
public class EstadoController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/estados")
	@Transactional
	public String cadastro(@RequestBody @Valid EstadoForm form) {
		Estado estado = form.toModel(manager);
		manager.persist(estado);
		return estado.toString();
	}

}
