package co.com.coomeva.coben.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.coomeva.coben.domain.UbicacionBeneficio;
import co.com.coomeva.coben.exception.ZMessManager;
import co.com.coomeva.coben.repository.UbicacionBeneficioRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@Scope("singleton")
@Service
@Slf4j
public class UbicacionBeneficioServiceImpl implements UbicacionBeneficioService {
	@Autowired
	private UbicacionBeneficioRepository ubicacionBeneficioRepository;
	@Autowired
	private Validator validator;

	@Override
	public void validate(UbicacionBeneficio ubicacionBeneficio) throws ConstraintViolationException {
		Set<ConstraintViolation<UbicacionBeneficio>> constraintViolations = validator.validate(ubicacionBeneficio);

		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return ubicacionBeneficioRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<UbicacionBeneficio> findAll() {
		log.debug("finding all UbicacionBeneficio instances");

		return ubicacionBeneficioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public UbicacionBeneficio save(UbicacionBeneficio entity) throws Exception {
		log.debug("saving UbicacionBeneficio instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("UbicacionBeneficio");
		}

		validate(entity);

		if (ubicacionBeneficioRepository.existsById(entity.getIdub())) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return ubicacionBeneficioRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(UbicacionBeneficio entity) throws Exception {
		log.debug("deleting UbicacionBeneficio instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("UbicacionBeneficio");
		}

		if (entity.getIdub() == null) {
			throw new ZMessManager().new EmptyFieldException("idub");
		}

		if (ubicacionBeneficioRepository.existsById(entity.getIdub()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		ubicacionBeneficioRepository.deleteById(entity.getIdub());
		log.debug("delete UbicacionBeneficio successful");
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		log.debug("deleting UbicacionBeneficio instance");

		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("idub");
		}

		if (ubicacionBeneficioRepository.existsById(id)) {
			delete(ubicacionBeneficioRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public UbicacionBeneficio update(UbicacionBeneficio entity) throws Exception {
		log.debug("updating UbicacionBeneficio instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("UbicacionBeneficio");
		}

		validate(entity);

		if (ubicacionBeneficioRepository.existsById(entity.getIdub()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return ubicacionBeneficioRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<UbicacionBeneficio> findById(Integer idub) throws Exception {
		log.debug("getting UbicacionBeneficio instance");

		return ubicacionBeneficioRepository.findById(idub);
	}
}
