package br.com.entra21.backend.spring.exercicio.sql.entra21Exercicio.model;

import java.util.ArrayList;

public class ItemNivel3 {

	private String ref;
	private String url;
	
	public ItemNivel3() {
	super();
	}
	
	public ItemNivel3(String ref, String url) {
		super();
		this.ref = ref;
		this.url = url;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}