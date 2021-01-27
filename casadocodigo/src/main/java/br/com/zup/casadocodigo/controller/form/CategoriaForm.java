package br.com.zup.casadocodigo.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.modelo.Categoria;
import br.com.zup.casadocodigo.validacao.UniqueValue;

public class CategoriaForm {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Categoria já cadastrada!")
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {

		return this.nome;
	}

}
