package br.com.pilares.multiform.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.pilares.multiform.model.form.DocumentoForm;
import br.com.pilares.multiform.service.DocumentoService;

@RestController
@RequestMapping("/documento")
public class DocumentoController {
	
	private DocumentoService documentoService;
	
	public DocumentoController(DocumentoService documentoService) {
		this.documentoService = documentoService;
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return documentoService.getAll();
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestPart List<MultipartFile> files, @RequestPart String numero){
		return documentoService.register(new DocumentoForm(files, numero));
	}
	
	
}
