package br.com.zup.casadocodigo.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.casadocodigo.modelo.Autor;
import br.com.zup.casadocodigo.validacao.UniqueValue;

public class AutorForm {

	@NotBlank
	private String nome;

	@Email
	@NotBlank
	@UniqueValue(domainClass = Autor.class, fieldName = "email", message = "Email já cadastrado!")
	private String email;

	@NotBlank
	@Size(max = 400)
	private String descricao;

	public AutorForm(@NotBlank String nome, @Email @NotBlank String email,
			@NotBlank @Size(max = 400) String descricao) {

		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {

		return new Autor(this.nome, this.email, this.descricao);
	}

	public String getEmail() {

		return this.email;
	}

}
