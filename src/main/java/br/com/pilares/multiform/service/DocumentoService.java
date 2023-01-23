package br.com.pilares.multiform.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.pilares.multiform.model.dto.DocumentoDTO;
import br.com.pilares.multiform.model.entity.Anexo;
import br.com.pilares.multiform.model.entity.Documento;
import br.com.pilares.multiform.model.form.DocumentoForm;
import br.com.pilares.multiform.repositories.AnexoRepository;
import br.com.pilares.multiform.repositories.DocumentoRepository;

@Service
public class DocumentoService {
	
	private DocumentoRepository documentoRepository;
	private AnexoRepository anexoRepository;
	
	public DocumentoService(DocumentoRepository documentoRepository, AnexoRepository anexoRepository) {
		this.documentoRepository = documentoRepository;
		this.anexoRepository = anexoRepository;
	}

	public ResponseEntity<?> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(
					DocumentoDTO.converter(
							documentoRepository.findAll()
					)
				);
	}

	public ResponseEntity<?> register(DocumentoForm form) {
		Documento documento = documentoRepository.save(new Documento(form));
		List<Anexo> anexos = new ArrayList<>();
		for (MultipartFile file: form.getFiles()) {
			anexos.add(anexoRepository.save(new Anexo(file, documento)));
		}
		documento.setAnexo(anexos);
		return ResponseEntity.status(HttpStatus.CREATED).body(new DocumentoDTO(documento));
	}

}
