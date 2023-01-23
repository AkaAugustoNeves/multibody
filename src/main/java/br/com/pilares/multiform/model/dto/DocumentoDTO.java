package br.com.pilares.multiform.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.pilares.multiform.model.entity.Documento;

public class DocumentoDTO {
	
	private Long id;
	private String numero;
	private String hash;
	private List<AnexoDTO> anexos = new ArrayList<AnexoDTO>();
	
	public DocumentoDTO(Documento documento) {
		this.id = documento.getId();
		this.numero = documento.getNumero();
		this.hash = documento.getHash();
		this.anexos = AnexoDTO.converter(documento.getAnexo());
	}
	
	public static List<DocumentoDTO> converter(List<Documento> anexos){
		return anexos.stream().map(DocumentoDTO::new).collect(Collectors.toList());
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

	public List<AnexoDTO> getAnexos() {
		return anexos;
	}

	public void setAnexos(List<AnexoDTO> anexos) {
		this.anexos = anexos;
	}

}