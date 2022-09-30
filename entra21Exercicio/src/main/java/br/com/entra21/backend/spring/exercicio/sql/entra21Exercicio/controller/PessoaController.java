package br.com.entra21.backend.spring.exercicio.sql.entra21Exercicio.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.entra21.backend.spring.exercicio.sql.entra21Exercicio.model.ItemNivel3;
import br.com.entra21.backend.spring.exercicio.sql.entra21Exercicio.model.Pessoa;
import br.com.entra21.backend.spring.exercicio.sql.entra21Exercicio.repository.IPessoaRepository;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private IPessoaRepository pessoaRepository;

	@ResponseStatus(HttpStatus.OK)
	public List<Pessoa> listar() {

		List<Pessoa> response = pessoaRepository.findAll();
		response.forEach(pessoa -> {
			setMaturidadeNivel3(pessoa);
		});

		return response;
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<Pessoa> buscar(@PathVariable("id") int param) {

		List<Pessoa> response = pessoaRepository.findById(param).stream().toList();

		return response;
	}

	@GetMapping
	public List<Pessoa> listAll() {

		return pessoaRepository.findAll();
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Pessoa adicionar(@RequestBody Pessoa novaPessoa) {

		return pessoaRepository.save(novaPessoa);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Optional<Pessoa> atualizar(@PathVariable("id") int param, @RequestBody Pessoa pessoaNovosDados) {

		Pessoa atual = pessoaRepository.findById(param).get();
		atual.setFirstname(pessoaNovosDados.getFirstname());
		atual.setLastname(pessoaNovosDados.getLastname());
		atual.setAge(pessoaNovosDados.getAge());
		atual.setActive(pessoaNovosDados.getActive());
		pessoaRepository.save(atual);

		return pessoaRepository.findById(param);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody boolean deletar(@PathVariable("id") int id) {
		pessoaRepository.deleteById(id);

		return !pessoaRepository.existsById(id);
	}
	
	@GetMapping(value = "/byage/{age}")
	public List<Pessoa> getByAge(@PathVariable("age") Integer age) {
		return pessoaRepository.findByAge(age);
	}
	
	@GetMapping(value = "/nameandage/{name}/{age}")
	public List<Pessoa> getByAgeName(@PathVariable("nome") String nome, @PathVariable("idade") Integer idade) {
		return pessoaRepository.findByFirstnameAndAge(nome , idade);
	}
	
	@GetMapping(value = "/lessthanequalage/{age}")
	public List<Pessoa> getByAgeLessThanEqual(@PathVariable("age") Integer age) {
		return pessoaRepository.findByAgeLessThanEqual(age);
	}
	
	//@GetMapping(value = "/comecacom/{prefixo}/{age}")
	//List<Pessoa> getStartsWith(@PathVariable("prefixo") String sla, @PathVariable("age") Integer anos) {
	//	return pessoaRepository.findByLastNameStartingWithAndAgeLessThanEqual(sla, anos);
	//}
	
	
	private void setMaturidadeNivel3(Pessoa pessoa) {

		final String PATH = "localhost:8080/pessoas";
	
		pessoa.setLinks(new ArrayList<>());
		pessoa.getLinks().add(new ItemNivel3("GET", PATH));
		pessoa.getLinks().add(new ItemNivel3("GET", PATH + "/" + pessoa.getId()));
		pessoa.getLinks().add(new ItemNivel3("POST", PATH));
		pessoa.getLinks().add(new ItemNivel3("PUT", PATH + "/" + pessoa.getId()));
		pessoa.getLinks().add(new ItemNivel3("DELETE", PATH + "/" + pessoa.getId()));
	}
}
