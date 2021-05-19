package br.com.zupacademy.joaog.casadocodigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.joaog.casadocodigo.model.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long>{

	public boolean existsByEmailIgnoreCase(String email);
}
