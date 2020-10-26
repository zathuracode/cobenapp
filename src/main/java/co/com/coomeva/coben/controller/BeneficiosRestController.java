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

import co.com.coomeva.coben.domain.Beneficios;
import co.com.coomeva.coben.dto.BeneficiosDTO;
import co.com.coomeva.coben.mapper.BeneficiosMapper;
import co.com.coomeva.coben.service.BeneficiosService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/beneficios")
@CrossOrigin(origins = "*")
@Slf4j
public class BeneficiosRestController {
	@Autowired
	private BeneficiosService beneficiosService;
	@Autowired
	private BeneficiosMapper beneficiosMapper;

	@GetMapping(value = "/{idbeneficio}")
	public ResponseEntity<?> findById(@PathVariable("idbeneficio") Integer idbeneficio) throws Exception {
		log.debug("Request to findById() Beneficios");

		Beneficios beneficios = (beneficiosService.findById(idbeneficio).isPresent() == true)
				? beneficiosService.findById(idbeneficio).get()
				: null;

		return ResponseEntity.ok().body(beneficiosMapper.beneficiosToBeneficiosDTO(beneficios));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {
		log.debug("Request to findAll() Beneficios");

		return ResponseEntity.ok()
				.body(beneficiosMapper.listBeneficiosToListBeneficiosDTO(beneficiosService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody BeneficiosDTO beneficiosDTO) throws Exception {
		log.debug("Request to save Beneficios: {}", beneficiosDTO);

		Beneficios beneficios = beneficiosMapper.beneficiosDTOToBeneficios(beneficiosDTO);
		beneficios = beneficiosService.save(beneficios);

		return ResponseEntity.ok().body(beneficiosMapper.beneficiosToBeneficiosDTO(beneficios));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody BeneficiosDTO beneficiosDTO) throws Exception {
		log.debug("Request to update Beneficios: {}", beneficiosDTO);

		Beneficios beneficios = beneficiosMapper.beneficiosDTOToBeneficios(beneficiosDTO);
		beneficios = beneficiosService.update(beneficios);

		return ResponseEntity.ok().body(beneficiosMapper.beneficiosToBeneficiosDTO(beneficios));
	}

	@DeleteMapping(value = "/{idbeneficio}")
	public ResponseEntity<?> delete(@PathVariable("idbeneficio") Integer idbeneficio) throws Exception {
		log.debug("Request to delete Beneficios");

		beneficiosService.deleteById(idbeneficio);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(beneficiosService.count());
	}
}
