package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.controller.form.PaisesForm;
import br.com.zup.casadocodigo.modelo.Pais;

@RestController
public class PaisesController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/paises")
	@Transactional
	public String cadastro(@RequestBody @Valid PaisesForm form) {
		Pais pais = new Pais(form.getNome());
		manager.persist(pais);
		return pais.toString();
	}

}
