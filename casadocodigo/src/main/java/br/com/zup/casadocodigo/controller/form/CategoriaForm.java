package br.com.zup.casadocodigo.controller.form;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

	@NotBlank
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {

		return this.nome;
	}

}
