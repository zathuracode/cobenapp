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

import co.com.coomeva.coben.domain.UbicacionBeneficio;
import co.com.coomeva.coben.dto.UbicacionBeneficioDTO;
import co.com.coomeva.coben.mapper.UbicacionBeneficioMapper;
import co.com.coomeva.coben.service.UbicacionBeneficioService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/ubicacionBeneficio")
@CrossOrigin(origins = "*")
@Slf4j
public class UbicacionBeneficioRestController {
	@Autowired
	private UbicacionBeneficioService ubicacionBeneficioService;
	@Autowired
	private UbicacionBeneficioMapper ubicacionBeneficioMapper;

	@GetMapping(value = "/{idub}")
	public ResponseEntity<?> findById(@PathVariable("idub") Integer idub) throws Exception {
		log.debug("Request to findById() UbicacionBeneficio");

		UbicacionBeneficio ubicacionBeneficio = (ubicacionBeneficioService.findById(idub).isPresent() == true)
				? ubicacionBeneficioService.findById(idub).get()
				: null;

		return ResponseEntity.ok()
				.body(ubicacionBeneficioMapper.ubicacionBeneficioToUbicacionBeneficioDTO(ubicacionBeneficio));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {
		log.debug("Request to findAll() UbicacionBeneficio");

		return ResponseEntity.ok().body(ubicacionBeneficioMapper
				.listUbicacionBeneficioToListUbicacionBeneficioDTO(ubicacionBeneficioService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody UbicacionBeneficioDTO ubicacionBeneficioDTO) throws Exception {
		log.debug("Request to save UbicacionBeneficio: {}", ubicacionBeneficioDTO);

		UbicacionBeneficio ubicacionBeneficio = ubicacionBeneficioMapper
				.ubicacionBeneficioDTOToUbicacionBeneficio(ubicacionBeneficioDTO);
		ubicacionBeneficio = ubicacionBeneficioService.save(ubicacionBeneficio);

		return ResponseEntity.ok()
				.body(ubicacionBeneficioMapper.ubicacionBeneficioToUbicacionBeneficioDTO(ubicacionBeneficio));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody UbicacionBeneficioDTO ubicacionBeneficioDTO) throws Exception {
		log.debug("Request to update UbicacionBeneficio: {}", ubicacionBeneficioDTO);

		UbicacionBeneficio ubicacionBeneficio = ubicacionBeneficioMapper
				.ubicacionBeneficioDTOToUbicacionBeneficio(ubicacionBeneficioDTO);
		ubicacionBeneficio = ubicacionBeneficioService.update(ubicacionBeneficio);

		return ResponseEntity.ok()
				.body(ubicacionBeneficioMapper.ubicacionBeneficioToUbicacionBeneficioDTO(ubicacionBeneficio));
	}

	@DeleteMapping(value = "/{idub}")
	public ResponseEntity<?> delete(@PathVariable("idub") Integer idub) throws Exception {
		log.debug("Request to delete UbicacionBeneficio");

		ubicacionBeneficioService.deleteById(idub);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(ubicacionBeneficioService.count());
	}
}
