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

import co.com.coomeva.coben.domain.UsoBeneficio;
import co.com.coomeva.coben.dto.UsoBeneficioDTO;
import co.com.coomeva.coben.mapper.UsoBeneficioMapper;
import co.com.coomeva.coben.service.UsoBeneficioService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/usoBeneficio")
@CrossOrigin(origins = "*")
@Slf4j
public class UsoBeneficioRestController {
	@Autowired
	private UsoBeneficioService usoBeneficioService;
	@Autowired
	private UsoBeneficioMapper usoBeneficioMapper;

	@GetMapping(value = "/{iduso}")
	public ResponseEntity<?> findById(@PathVariable("iduso") Integer iduso) throws Exception {
		log.debug("Request to findById() UsoBeneficio");

		UsoBeneficio usoBeneficio = (usoBeneficioService.findById(iduso).isPresent() == true)
				? usoBeneficioService.findById(iduso).get()
				: null;

		return ResponseEntity.ok().body(usoBeneficioMapper.usoBeneficioToUsoBeneficioDTO(usoBeneficio));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {
		log.debug("Request to findAll() UsoBeneficio");

		return ResponseEntity.ok()
				.body(usoBeneficioMapper.listUsoBeneficioToListUsoBeneficioDTO(usoBeneficioService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody UsoBeneficioDTO usoBeneficioDTO) throws Exception {
		log.debug("Request to save UsoBeneficio: {}", usoBeneficioDTO);

		UsoBeneficio usoBeneficio = usoBeneficioMapper.usoBeneficioDTOToUsoBeneficio(usoBeneficioDTO);
		usoBeneficio = usoBeneficioService.save(usoBeneficio);

		return ResponseEntity.ok().body(usoBeneficioMapper.usoBeneficioToUsoBeneficioDTO(usoBeneficio));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody UsoBeneficioDTO usoBeneficioDTO) throws Exception {
		log.debug("Request to update UsoBeneficio: {}", usoBeneficioDTO);

		UsoBeneficio usoBeneficio = usoBeneficioMapper.usoBeneficioDTOToUsoBeneficio(usoBeneficioDTO);
		usoBeneficio = usoBeneficioService.update(usoBeneficio);

		return ResponseEntity.ok().body(usoBeneficioMapper.usoBeneficioToUsoBeneficioDTO(usoBeneficio));
	}

	@DeleteMapping(value = "/{iduso}")
	public ResponseEntity<?> delete(@PathVariable("iduso") Integer iduso) throws Exception {
		log.debug("Request to delete UsoBeneficio");

		usoBeneficioService.deleteById(iduso);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(usoBeneficioService.count());
	}
}
