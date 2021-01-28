package br.com.zup.casadocodigo.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.casadocodigo.modelo.Livro;

public interface LivroRepository extends CrudRepository<Livro, Long> {

}
