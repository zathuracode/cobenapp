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

import co.com.coomeva.coben.domain.Preferencias;
import co.com.coomeva.coben.exception.ZMessManager;
import co.com.coomeva.coben.repository.PreferenciasRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@Scope("singleton")
@Service
@Slf4j
public class PreferenciasServiceImpl implements PreferenciasService {
	@Autowired
	private PreferenciasRepository preferenciasRepository;
	@Autowired
	private Validator validator;

	@Override
	public void validate(Preferencias preferencias) throws ConstraintViolationException {
		Set<ConstraintViolation<Preferencias>> constraintViolations = validator.validate(preferencias);

		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return preferenciasRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Preferencias> findAll() {
		log.debug("finding all Preferencias instances");

		return preferenciasRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Preferencias save(Preferencias entity) throws Exception {
		log.debug("saving Preferencias instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Preferencias");
		}

		validate(entity);

		if (preferenciasRepository.existsById(entity.getIdprfcs())) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return preferenciasRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Preferencias entity) throws Exception {
		log.debug("deleting Preferencias instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Preferencias");
		}

		if (entity.getIdprfcs() == null) {
			throw new ZMessManager().new EmptyFieldException("idprfcs");
		}

		if (preferenciasRepository.existsById(entity.getIdprfcs()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		preferenciasRepository.deleteById(entity.getIdprfcs());
		log.debug("delete Preferencias successful");
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		log.debug("deleting Preferencias instance");

		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("idprfcs");
		}

		if (preferenciasRepository.existsById(id)) {
			delete(preferenciasRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Preferencias update(Preferencias entity) throws Exception {
		log.debug("updating Preferencias instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Preferencias");
		}

		validate(entity);

		if (preferenciasRepository.existsById(entity.getIdprfcs()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return preferenciasRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Preferencias> findById(Integer idprfcs) throws Exception {
		log.debug("getting Preferencias instance");

		return preferenciasRepository.findById(idprfcs);
	}
}
