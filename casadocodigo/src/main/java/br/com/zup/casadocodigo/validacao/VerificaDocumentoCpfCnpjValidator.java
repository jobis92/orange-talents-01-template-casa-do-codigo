package br.com.zup.casadocodigo.validacao;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.controller.form.PagamentoForm;

public class VerificaDocumentoCpfCnpjValidator implements Validator {

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

		if (!request.cpfOuCnpjValido()) {
			errors.rejectValue("cpfOuCnpj", null, "documento precisa ser CPF ou CNPJ!");
		}
	}

}
