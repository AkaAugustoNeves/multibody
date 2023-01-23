package br.com.pilares.multiform.model.form;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public class DocumentoForm {

	private String numero;
	private List<MultipartFile> files = new ArrayList<>();
	
	public DocumentoForm(List<MultipartFile> files, String numero) {
		this.numero = numero;
		this.files = files;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

}