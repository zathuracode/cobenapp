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

import co.com.coomeva.coben.domain.Proveedores;
import co.com.coomeva.coben.dto.ProveedoresDTO;
import co.com.coomeva.coben.mapper.ProveedoresMapper;
import co.com.coomeva.coben.service.ProveedoresService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/proveedores")
@CrossOrigin(origins = "*")
@Slf4j
public class ProveedoresRestController {
	@Autowired
	private ProveedoresService proveedoresService;
	@Autowired
	private ProveedoresMapper proveedoresMapper;

	@GetMapping(value = "/{idprovd}")
	public ResponseEntity<?> findById(@PathVariable("idprovd") Integer idprovd) throws Exception {
		log.debug("Request to findById() Proveedores");

		Proveedores proveedores = (proveedoresService.findById(idprovd).isPresent() == true)
				? proveedoresService.findById(idprovd).get()
				: null;

		return ResponseEntity.ok().body(proveedoresMapper.proveedoresToProveedoresDTO(proveedores));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {
		log.debug("Request to findAll() Proveedores");

		return ResponseEntity.ok()
				.body(proveedoresMapper.listProveedoresToListProveedoresDTO(proveedoresService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody ProveedoresDTO proveedoresDTO) throws Exception {
		log.debug("Request to save Proveedores: {}", proveedoresDTO);

		Proveedores proveedores = proveedoresMapper.proveedoresDTOToProveedores(proveedoresDTO);
		proveedores = proveedoresService.save(proveedores);

		return ResponseEntity.ok().body(proveedoresMapper.proveedoresToProveedoresDTO(proveedores));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody ProveedoresDTO proveedoresDTO) throws Exception {
		log.debug("Request to update Proveedores: {}", proveedoresDTO);

		Proveedores proveedores = proveedoresMapper.proveedoresDTOToProveedores(proveedoresDTO);
		proveedores = proveedoresService.update(proveedores);

		return ResponseEntity.ok().body(proveedoresMapper.proveedoresToProveedoresDTO(proveedores));
	}

	@DeleteMapping(value = "/{idprovd}")
	public ResponseEntity<?> delete(@PathVariable("idprovd") Integer idprovd) throws Exception {
		log.debug("Request to delete Proveedores");

		proveedoresService.deleteById(idprovd);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(proveedoresService.count());
	}
}
