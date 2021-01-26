package br.com.zup.casadocodigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.casadocodigo.modelo.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {

	
	
}
