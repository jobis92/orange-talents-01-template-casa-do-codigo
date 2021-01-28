package br.com.zup.casadocodigo.controller.dto;

import br.com.zup.casadocodigo.modelo.Autor;

public class detalhesDoAutorDto {

	private String nome;
	private String descricao;

	public detalhesDoAutorDto(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
