package br.com.zup.casadocodigo.validacao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.controller.form.PagamentoForm;
import br.com.zup.casadocodigo.modelo.Estado;
import br.com.zup.casadocodigo.modelo.Pais;

@Component
public class EstadoPertenceAPaisValidator implements Validator {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean supports(Class<?> clazz) {

		return PagamentoForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		PagamentoForm request = (PagamentoForm) target;

		Pais pais = manager.find(Pais.class, request.getIdPais());
		Estado estado = manager.find(Estado.class, request.getIdEstado());

		if (!estado.pertenceAPais(pais)) {
			errors.reject("idEstado", null, "este estado não é do pais selecionado!");
		}

	}

}
