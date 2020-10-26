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

import co.com.coomeva.coben.domain.CategoriaBeneficio;
import co.com.coomeva.coben.dto.CategoriaBeneficioDTO;
import co.com.coomeva.coben.mapper.CategoriaBeneficioMapper;
import co.com.coomeva.coben.service.CategoriaBeneficioService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/categoriaBeneficio")
@CrossOrigin(origins = "*")
@Slf4j
public class CategoriaBeneficioRestController {
	@Autowired
	private CategoriaBeneficioService categoriaBeneficioService;
	@Autowired
	private CategoriaBeneficioMapper categoriaBeneficioMapper;

	@GetMapping(value = "/{idcat}")
	public ResponseEntity<?> findById(@PathVariable("idcat") Integer idcat) throws Exception {
		log.debug("Request to findById() CategoriaBeneficio");

		CategoriaBeneficio categoriaBeneficio = (categoriaBeneficioService.findById(idcat).isPresent() == true)
				? categoriaBeneficioService.findById(idcat).get()
				: null;

		return ResponseEntity.ok()
				.body(categoriaBeneficioMapper.categoriaBeneficioToCategoriaBeneficioDTO(categoriaBeneficio));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {
		log.debug("Request to findAll() CategoriaBeneficio");

		return ResponseEntity.ok().body(categoriaBeneficioMapper
				.listCategoriaBeneficioToListCategoriaBeneficioDTO(categoriaBeneficioService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody CategoriaBeneficioDTO categoriaBeneficioDTO) throws Exception {
		log.debug("Request to save CategoriaBeneficio: {}", categoriaBeneficioDTO);

		CategoriaBeneficio categoriaBeneficio = categoriaBeneficioMapper
				.categoriaBeneficioDTOToCategoriaBeneficio(categoriaBeneficioDTO);
		categoriaBeneficio = categoriaBeneficioService.save(categoriaBeneficio);

		return ResponseEntity.ok()
				.body(categoriaBeneficioMapper.categoriaBeneficioToCategoriaBeneficioDTO(categoriaBeneficio));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody CategoriaBeneficioDTO categoriaBeneficioDTO) throws Exception {
		log.debug("Request to update CategoriaBeneficio: {}", categoriaBeneficioDTO);

		CategoriaBeneficio categoriaBeneficio = categoriaBeneficioMapper
				.categoriaBeneficioDTOToCategoriaBeneficio(categoriaBeneficioDTO);
		categoriaBeneficio = categoriaBeneficioService.update(categoriaBeneficio);

		return ResponseEntity.ok()
				.body(categoriaBeneficioMapper.categoriaBeneficioToCategoriaBeneficioDTO(categoriaBeneficio));
	}

	@DeleteMapping(value = "/{idcat}")
	public ResponseEntity<?> delete(@PathVariable("idcat") Integer idcat) throws Exception {
		log.debug("Request to delete CategoriaBeneficio");

		categoriaBeneficioService.deleteById(idcat);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(categoriaBeneficioService.count());
	}
}
