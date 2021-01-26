package br.com.zup.casadocodigo.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.controller.form.AutorForm;
import br.com.zup.casadocodigo.modelo.Autor;
import br.com.zup.casadocodigo.repository.AutorRepository;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {

		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		AutorForm request = (AutorForm) target;
		Optional<Autor> emails = autorRepository.findByEmail(request.getEmail());
		
		if (emails.isPresent()) {
			errors.rejectValue("email", null, "Email já cadastrado! " + request.getEmail());
		} else {

		}
	}
}
