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

import co.com.coomeva.coben.domain.Asociado;
import co.com.coomeva.coben.dto.AsociadoDTO;
import co.com.coomeva.coben.mapper.AsociadoMapper;
import co.com.coomeva.coben.service.AsociadoService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/asociado")
@CrossOrigin(origins = "*")
@Slf4j
public class AsociadoRestController {

	@Autowired
	private AsociadoService asociadoService;
	@Autowired
	private AsociadoMapper asociadoMapper;

	@GetMapping(value = "/{documento}")
	public ResponseEntity<?> findById(@PathVariable("documento") String documento) throws Exception {
		log.debug("Request to findById() Asociado");

		Asociado asociado = (asociadoService.findById(documento).isPresent() == true)
				? asociadoService.findById(documento).get()
				: null;

		return ResponseEntity.ok().body(asociadoMapper.asociadoToAsociadoDTO(asociado));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {
		log.debug("Request to findAll() Asociado");

		return ResponseEntity.ok().body(asociadoMapper.listAsociadoToListAsociadoDTO(asociadoService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody AsociadoDTO asociadoDTO) throws Exception {
		log.debug("Request to save Asociado: {}", asociadoDTO);

		Asociado asociado = asociadoMapper.asociadoDTOToAsociado(asociadoDTO);
		asociado = asociadoService.save(asociado);

		return ResponseEntity.ok().body(asociadoMapper.asociadoToAsociadoDTO(asociado));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody AsociadoDTO asociadoDTO) throws Exception {
		log.debug("Request to update Asociado: {}", asociadoDTO);

		Asociado asociado = asociadoMapper.asociadoDTOToAsociado(asociadoDTO);
		asociado = asociadoService.update(asociado);

		return ResponseEntity.ok().body(asociadoMapper.asociadoToAsociadoDTO(asociado));
	}

	@DeleteMapping(value = "/{documento}")
	public ResponseEntity<?> delete(@PathVariable("documento") String documento) throws Exception {
		log.debug("Request to delete Asociado");

		asociadoService.deleteById(documento);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(asociadoService.count());
	}
}
