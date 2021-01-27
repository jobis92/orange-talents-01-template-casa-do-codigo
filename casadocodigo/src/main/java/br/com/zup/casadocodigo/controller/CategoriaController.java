package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.controller.form.CategoriaForm;
import br.com.zup.casadocodigo.modelo.Categoria;

@RestController
public class CategoriaController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/categorias")
	@Transactional
	public String cadastro(@RequestBody @Valid CategoriaForm form) {
		Categoria categoria = new Categoria(form.getNome());
		manager.persist(categoria);
		return categoria.toString();

	}

}
