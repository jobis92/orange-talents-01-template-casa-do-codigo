package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.controller.dto.LivroDto;
import br.com.zup.casadocodigo.controller.form.LivroForm;
import br.com.zup.casadocodigo.modelo.Livro;
import br.com.zup.casadocodigo.repository.LivroRepository;

@RestController
public class LivroController {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping(value = "/listar")
	public Page<LivroDto> listar(
			@PageableDefault(sort = "titulo", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		Page<Livro> livros = livroRepository.findAll(paginacao);

		return LivroDto.converter(livros);
	}

	@PostMapping(value = "/livros")
	@Transactional
	public String cadastro(@RequestBody @Valid LivroForm form) {
		Livro livro = form.toModel(manager);
		manager.persist(livro);

		return livro.toString();
	}

}
