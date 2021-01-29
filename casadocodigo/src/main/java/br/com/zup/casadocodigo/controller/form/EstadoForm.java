package br.com.zup.casadocodigo.controller.form;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.modelo.Estado;
import br.com.zup.casadocodigo.modelo.Pais;
import br.com.zup.casadocodigo.validacao.ExistsId;
import br.com.zup.casadocodigo.validacao.UniqueValue;

public class EstadoForm {

	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome", message = "Estado já cadastrado!")
	private String nome;

	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	public EstadoForm(@NotBlank String nome, @NotNull Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	public Estado toModel(EntityManager manager) {
		@NotNull
		Pais pais = manager.find(Pais.class, idPais);
		return new Estado(this.nome, pais);
	}

}
