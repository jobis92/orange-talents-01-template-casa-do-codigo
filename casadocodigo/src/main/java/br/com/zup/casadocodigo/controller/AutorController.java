package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.controller.form.AutorForm;
import br.com.zup.casadocodigo.modelo.Autor;
import br.com.zup.casadocodigo.validacao.ProibeEmailDuplicadoAutorValidator;

@RestController
public class AutorController {

	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
	}

	@PostMapping(value = "/autores")
	@Transactional
	public String cadastro(@RequestBody @Valid AutorForm form) {
		Autor autor = form.toModel();
		manager.persist(autor);
		return autor.toString();

	}

}
