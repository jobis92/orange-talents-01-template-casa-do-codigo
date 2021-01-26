package br.com.zup.casadocodigo.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.controller.form.CategoriaForm;
import br.com.zup.casadocodigo.modelo.Categoria;
import br.com.zup.casadocodigo.repository.CategoriaRepository;

@Component
public class ProibeCategoriaDuplicadaValidator implements Validator {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public ProibeCategoriaDuplicadaValidator(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		CategoriaForm request = (CategoriaForm) target;
		Optional<Categoria> categorias = categoriaRepository.findByNome(request.getNome());

		if (categorias.isPresent()) {
			errors.rejectValue("nome", null, "Categoria já cadastrada! " + request.getNome());
		} else {

		}
	}

}
