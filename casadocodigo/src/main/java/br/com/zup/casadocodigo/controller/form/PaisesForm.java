package br.com.zup.casadocodigo.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.modelo.Pais;
import br.com.zup.casadocodigo.validacao.UniqueValue;

public class PaisesForm {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "País já cadastrado!")
	private String nome;

	public @NotBlank String getNome() {

		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
