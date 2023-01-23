package br.com.pilares.multiform.model.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Anexo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String hash;
	private String extensao;
	private String nome;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date data;
	@ManyToOne
	private Documento documento;
	
	public Anexo() {
		// TODO Auto-generated constructor stub
	}
	
	public Anexo(MultipartFile file, Documento documento) {
		this.hash = UUID.randomUUID().toString();
		this.extensao = file.getContentType();
		this.nome = file.getOriginalFilename();
		this.data = new Date();
		this.documento = documento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}