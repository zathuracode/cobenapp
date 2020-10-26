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

import co.com.coomeva.coben.domain.Preferencias;
import co.com.coomeva.coben.dto.PreferenciasDTO;
import co.com.coomeva.coben.mapper.PreferenciasMapper;
import co.com.coomeva.coben.service.PreferenciasService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/preferencias")
@CrossOrigin(origins = "*")
@Slf4j
public class PreferenciasRestController {
	@Autowired
	private PreferenciasService preferenciasService;
	@Autowired
	private PreferenciasMapper preferenciasMapper;

	@GetMapping(value = "/{idprfcs}")
	public ResponseEntity<?> findById(@PathVariable("idprfcs") Integer idprfcs) throws Exception {
		log.debug("Request to findById() Preferencias");

		Preferencias preferencias = (preferenciasService.findById(idprfcs).isPresent() == true)
				? preferenciasService.findById(idprfcs).get()
				: null;

		return ResponseEntity.ok().body(preferenciasMapper.preferenciasToPreferenciasDTO(preferencias));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {
		log.debug("Request to findAll() Preferencias");

		return ResponseEntity.ok()
				.body(preferenciasMapper.listPreferenciasToListPreferenciasDTO(preferenciasService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody PreferenciasDTO preferenciasDTO) throws Exception {
		log.debug("Request to save Preferencias: {}", preferenciasDTO);

		Preferencias preferencias = preferenciasMapper.preferenciasDTOToPreferencias(preferenciasDTO);
		preferencias = preferenciasService.save(preferencias);

		return ResponseEntity.ok().body(preferenciasMapper.preferenciasToPreferenciasDTO(preferencias));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody PreferenciasDTO preferenciasDTO) throws Exception {
		log.debug("Request to update Preferencias: {}", preferenciasDTO);

		Preferencias preferencias = preferenciasMapper.preferenciasDTOToPreferencias(preferenciasDTO);
		preferencias = preferenciasService.update(preferencias);

		return ResponseEntity.ok().body(preferenciasMapper.preferenciasToPreferenciasDTO(preferencias));
	}

	@DeleteMapping(value = "/{idprfcs}")
	public ResponseEntity<?> delete(@PathVariable("idprfcs") Integer idprfcs) throws Exception {
		log.debug("Request to delete Preferencias");

		preferenciasService.deleteById(idprfcs);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(preferenciasService.count());
	}
}
