package co.com.coomeva.coben.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.coomeva.coben.domain.TipoDocumento;
import co.com.coomeva.coben.dto.TipoDocumentoDTO;
import co.com.coomeva.coben.mapper.TipoDocumentoMapper;
import co.com.coomeva.coben.service.TipoDocumentoService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/tipoDocumento")
@CrossOrigin(origins = "*")
@Slf4j
public class TipoDocumentoRestController {
	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	@Autowired
	private TipoDocumentoMapper tipoDocumentoMapper;

	@GetMapping(value = "/{idtipo}")
	public ResponseEntity<?> findById(@PathVariable("idtipo") Integer idtipo) throws Exception {
		log.debug("Request to findById() TipoDocumento");

		TipoDocumento tipoDocumento = (tipoDocumentoService.findById(idtipo).isPresent() == true)
				? tipoDocumentoService.findById(idtipo).get()
				: null;

		return ResponseEntity.ok().body(tipoDocumentoMapper.tipoDocumentoToTipoDocumentoDTO(tipoDocumento));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {
		log.debug("Request to findAll() TipoDocumento");

		return ResponseEntity.ok()
				.body(tipoDocumentoMapper.listTipoDocumentoToListTipoDocumentoDTO(tipoDocumentoService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody TipoDocumentoDTO tipoDocumentoDTO) throws Exception {
		log.debug("Request to save TipoDocumento: {}", tipoDocumentoDTO);

		TipoDocumento tipoDocumento = tipoDocumentoMapper.tipoDocumentoDTOToTipoDocumento(tipoDocumentoDTO);
		tipoDocumento = tipoDocumentoService.save(tipoDocumento);

		return ResponseEntity.ok().body(tipoDocumentoMapper.tipoDocumentoToTipoDocumentoDTO(tipoDocumento));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody TipoDocumentoDTO tipoDocumentoDTO) throws Exception {
		log.debug("Request to update TipoDocumento: {}", tipoDocumentoDTO);

		TipoDocumento tipoDocumento = tipoDocumentoMapper.tipoDocumentoDTOToTipoDocumento(tipoDocumentoDTO);
		tipoDocumento = tipoDocumentoService.update(tipoDocumento);

		return ResponseEntity.ok().body(tipoDocumentoMapper.tipoDocumentoToTipoDocumentoDTO(tipoDocumento));
	}

	@DeleteMapping(value = "/{idtipo}")
	public ResponseEntity<?> delete(@PathVariable("idtipo") Integer idtipo) throws Exception {
		log.debug("Request to delete TipoDocumento");

		tipoDocumentoService.deleteById(idtipo);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(tipoDocumentoService.count());
	}
}
