//package br.com.zup.casadocodigo.modelo;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.OneToMany;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//
//import br.com.zup.casadocodigo.validacao.CPFOuCNPJ;
//
//@Entity
//public class Pagamento {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@NotBlank
//	@Email
//	private String email;
//
//	@NotBlank
//	private String nome;
//
//	@NotBlank
//	private String sobrenome;
//
//	@NotBlank
//	@CPFOuCNPJ
//	private String cpfOuCnpj;
//
//	@NotBlank
//	private String endereco;
//
//	@NotBlank
//	private String complemento;
//
//	@NotBlank
//	private String cidade;
//
//	@NotNull
//	@ManyToMany
//	private Pais pais;
//
//	@NotNull
//	@OneToMany
//	private Estado estado;
//
//	@NotBlank
//	private String telefone;
//
//	@NotBlank
//	private String cep;
//
//	@Deprecated
//	public Pagamento() {
//	}
//
//	public Pagamento(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
//			@NotBlank String cpfOuCnpj, @NotBlank String endereco, @NotBlank String complemento,
//			@NotBlank String cidade, @NotNull Pais pais, @NotNull Estado estado, @NotBlank String telefone,
//			@NotBlank String cep) {
//		this.email = email;
//		this.nome = nome;
//		this.sobrenome = sobrenome;
//		this.cpfOuCnpj = cpfOuCnpj;
//		this.endereco = endereco;
//		this.complemento = complemento;
//		this.cidade = cidade;
//		this.pais = pais;
//		this.estado = estado;
//		this.telefone = telefone;
//		this.cep = cep;
//
//	}
//
//	@Override
//	public String toString() {
//		return "Pagamento [id=" + id + ", email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome
//				+ ", cpfOuCnpj=" + cpfOuCnpj + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade="
//				+ cidade + ", pais=" + pais + ", estado=" + estado + ", telefone=" + telefone + ", cep=" + cep + "]";
//	}
//
//}
