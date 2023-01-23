package br.com.pilares.multiform.model.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.pilares.multiform.model.entity.Anexo;

public class AnexoDTO {
	
	private Long id;
	private String hash;
	private String extensao;
	private String nome;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date data;
	
	public static List<AnexoDTO> converter(List<Anexo> anexos){
		return anexos.stream().map(AnexoDTO::new).collect(Collectors.toList());
	}
	
	public AnexoDTO(Anexo anexo) {
		this.id = anexo.getId();
		this.hash = anexo.getHash();
		this.extensao = anexo.getExtensao();
		this.nome = anexo.getNome();
		this.data = anexo.getData();
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
