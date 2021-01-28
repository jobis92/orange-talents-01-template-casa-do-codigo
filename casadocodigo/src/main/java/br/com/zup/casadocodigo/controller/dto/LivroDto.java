package br.com.zup.casadocodigo.controller.dto;

import org.springframework.data.domain.Page;

import br.com.zup.casadocodigo.modelo.Livro;

public class LivroDto {

	private Long id;
	private String nome;

	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.nome = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public static Page<LivroDto> converter(Page<Livro> livros) {

		return livros.map(LivroDto::new);
	}

}
