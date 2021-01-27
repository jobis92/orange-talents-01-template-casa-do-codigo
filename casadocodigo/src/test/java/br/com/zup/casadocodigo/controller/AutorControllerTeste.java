package br.com.zup.casadocodigo.controller;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import br.com.zup.casadocodigo.controller.form.AutorForm;
import br.com.zup.casadocodigo.modelo.Autor;
import br.com.zup.casadocodigo.repository.AutorRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AutorControllerTeste {

	@DisplayName("Deve lidar com email duplicado")
	@ParameterizedTest
	@MethodSource("geradorTeste1")
	void validaEmailDuplicadoTeste(Optional<Autor> possivelAutor, boolean esperado) {
		AutorRepository autorRepository = Mockito.mock(AutorRepository.class);
		// UniqueValueValidator validator = new UniqueValueValidator(autorRepository);
		Object target = new AutorForm("joao", "joao@hotmail.com", "teste");
		Errors errors = new BeanPropertyBindingResult(target, "teste");
		Mockito.when(autorRepository.findByEmail("joao@hotmail.com")).thenReturn(possivelAutor);

		// validator.validate(target, errors);

		Assertions.assertEquals(esperado, errors.hasFieldErrors("email"));
	}

	private static Stream<Arguments> geradorTeste1() {
		Optional<Autor> autor = Optional.of(new Autor("joao", "joao@hotmail.com", "teste"));
		return Stream.of(Arguments.of(autor, true), Arguments.of(Optional.empty(), false));
	}

}
