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

import co.com.coomeva.coben.domain.UsoBeneficio;
import co.com.coomeva.coben.exception.ZMessManager;
import co.com.coomeva.coben.repository.UsoBeneficioRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@Scope("singleton")
@Service
@Slf4j
public class UsoBeneficioServiceImpl implements UsoBeneficioService {
	@Autowired
	private UsoBeneficioRepository usoBeneficioRepository;
	@Autowired
	private Validator validator;

	@Override
	public void validate(UsoBeneficio usoBeneficio) throws ConstraintViolationException {
		Set<ConstraintViolation<UsoBeneficio>> constraintViolations = validator.validate(usoBeneficio);

		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return usoBeneficioRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<UsoBeneficio> findAll() {
		log.debug("finding all UsoBeneficio instances");

		return usoBeneficioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public UsoBeneficio save(UsoBeneficio entity) throws Exception {
		log.debug("saving UsoBeneficio instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("UsoBeneficio");
		}

		validate(entity);

		if (usoBeneficioRepository.existsById(entity.getIduso())) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return usoBeneficioRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(UsoBeneficio entity) throws Exception {
		log.debug("deleting UsoBeneficio instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("UsoBeneficio");
		}

		if (entity.getIduso() == null) {
			throw new ZMessManager().new EmptyFieldException("iduso");
		}

		if (usoBeneficioRepository.existsById(entity.getIduso()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		usoBeneficioRepository.deleteById(entity.getIduso());
		log.debug("delete UsoBeneficio successful");
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		log.debug("deleting UsoBeneficio instance");

		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("iduso");
		}

		if (usoBeneficioRepository.existsById(id)) {
			delete(usoBeneficioRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public UsoBeneficio update(UsoBeneficio entity) throws Exception {
		log.debug("updating UsoBeneficio instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("UsoBeneficio");
		}

		validate(entity);

		if (usoBeneficioRepository.existsById(entity.getIduso()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return usoBeneficioRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<UsoBeneficio> findById(Integer iduso) throws Exception {
		log.debug("getting UsoBeneficio instance");

		return usoBeneficioRepository.findById(iduso);
	}
}
