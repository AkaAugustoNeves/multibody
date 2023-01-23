package br.com.pilares.multiform.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.pilares.multiform.model.form.DocumentoForm;

@Entity
public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String numero;
	private String hash;
	@OneToMany(mappedBy = "documento")
	private List<Anexo> anexo = new ArrayList<Anexo>();
	
	public Documento() {
		// TODO Auto-generated constructor stub
	}
	
	public Documento(DocumentoForm form) {
		this.numero = form.getNumero();
		this.hash = UUID.randomUUID().toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public List<Anexo> getAnexo() {
		return anexo;
	}

	public void setAnexo(List<Anexo> anexo) {
		this.anexo = anexo;
	}
	
}
