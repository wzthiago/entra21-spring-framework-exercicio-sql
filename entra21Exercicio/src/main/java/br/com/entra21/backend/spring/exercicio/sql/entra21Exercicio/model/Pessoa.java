package br.com.entra21.backend.spring.exercicio.sql.entra21Exercicio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoas")
public class Pessoa extends MaturidadeNivel3Richardson{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstname;
	private String lastname;
	private Integer age;
	private Boolean active;
	
	public Pessoa() {
		super();
	}

	public Pessoa(Integer id, String firstname, String lastname, Integer age, Boolean active) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
