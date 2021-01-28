package br.com.zup.casadocodigo.controller.dto;

import java.math.BigDecimal;

import br.com.zup.casadocodigo.modelo.Livro;

public class DetalhesDoLivroDto {

	private Long id;
	private String titulo;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	private Integer numeroPaginas;
	private String isbn;
	private detalhesDoAutorDto autor;

	public DetalhesDoLivroDto(Livro detalhesDoLivroDto) {
		titulo = detalhesDoLivroDto.getTitulo();
		resumo = detalhesDoLivroDto.getResumo();
		sumario = detalhesDoLivroDto.getSumario();
		preco = detalhesDoLivroDto.getPreco();
		numeroPaginas = detalhesDoLivroDto.getNumeroPaginas();
		isbn = detalhesDoLivroDto.getIsbn();
		autor = new detalhesDoAutorDto(detalhesDoLivroDto.getAutor());
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public detalhesDoAutorDto getAutor() {
		return autor;
	}

}
