package br.com.zup.casadocodigo.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import br.com.zup.casadocodigo.modelo.Estado;
import br.com.zup.casadocodigo.modelo.Pais;
import br.com.zup.casadocodigo.validacao.ExistsId;

public class PagamentoForm {

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	private String cpfOuCnpj;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	@NotNull
	@ExistsId(domainClass = Estado.class, fieldName = "id")
	private Long idEstado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public PagamentoForm(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String cpfOuCnpj, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long idPais, @NotNull Long idEstado, @NotBlank String telefone,
			@NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpfOuCnpj = cpfOuCnpj;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "PagamentoForm [email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", cpfOuCnpj="
				+ cpfOuCnpj + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", idPais=" + idPais + ", idEstado=" + idEstado + ", telefone=" + telefone + ", cep=" + cep + "]";
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;

	}

	public boolean cpfOuCnpjValido() {
		Assert.hasLength(cpfOuCnpj, "você não deveria validar o documento se ele não tiver sido preenchido");

		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);

		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);

		return cpfValidator.isValid(cpfOuCnpj, null) || cnpjValidator.isValid(cpfOuCnpj, null);
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

//	public Pagamento toModel(EntityManager manager) {
//
//		@NotNull
//		Pais pais = manager.find(Pais.class, idPais);
//		@NotNull
//		Estado estado = manager.find(Estado.class, idEstado);
//
//		return new Pagamento(this.email, this.nome, this.sobrenome, this.cpfOuCnpj, this.endereco, this.complemento,
//				this.cidade, pais, estado, this.telefone, this.cep);
//	}

}
