package br.com.pilares.multiform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pilares.multiform.model.entity.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long>{

}
