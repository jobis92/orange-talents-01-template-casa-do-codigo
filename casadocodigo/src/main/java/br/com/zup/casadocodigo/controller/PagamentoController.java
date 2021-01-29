package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.controller.form.PagamentoForm;
import br.com.zup.casadocodigo.validacao.EstadoPertenceAPaisValidator;
import br.com.zup.casadocodigo.validacao.VerificaDocumentoCpfCnpjValidator;

@RestController
public class PagamentoController {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;

	@InitBinder
	private void init(WebDataBinder binder) {

		binder.addValidators(new VerificaDocumentoCpfCnpjValidator());
	}

	@PostMapping(value = "/pagamentos")
	public String cadastro(@RequestBody @Valid PagamentoForm form) {
		return form.toString();
	}

}
