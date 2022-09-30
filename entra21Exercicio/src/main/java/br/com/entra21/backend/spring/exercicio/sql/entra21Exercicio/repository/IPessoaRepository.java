package br.com.entra21.backend.spring.exercicio.sql.entra21Exercicio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.entra21.backend.spring.exercicio.sql.entra21Exercicio.model.Pessoa;

@Repository
@EnableJpaRepositories
public interface IPessoaRepository extends  JpaRepository<Pessoa, Integer> {
	
	public List<Pessoa> findByAge(Integer age);
	
	public List<Pessoa> findByFirstnameAndAge(String name, Integer age);
	
	public List<Pessoa> findByAgeLessThanEqual(Integer age);

	//public List<Pessoa> findByLastNameStartingWithAndAgeLessThanEqual(String prefixo, Integer age);


	
}
