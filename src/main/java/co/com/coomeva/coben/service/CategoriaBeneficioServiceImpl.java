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

import co.com.coomeva.coben.domain.Beneficios;
import co.com.coomeva.coben.domain.CategoriaBeneficio;
import co.com.coomeva.coben.exception.ZMessManager;
import co.com.coomeva.coben.repository.CategoriaBeneficioRepository;
import co.com.coomeva.coben.utility.Utilities;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
@Slf4j
public class CategoriaBeneficioServiceImpl implements CategoriaBeneficioService {

	@Autowired
	private CategoriaBeneficioRepository categoriaBeneficioRepository;

	@Autowired
	private Validator validator;

	@Override
	public void validate(CategoriaBeneficio categoriaBeneficio) throws ConstraintViolationException {

		Set<ConstraintViolation<CategoriaBeneficio>> constraintViolations = validator.validate(categoriaBeneficio);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return categoriaBeneficioRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<CategoriaBeneficio> findAll() {
		log.debug("finding all CategoriaBeneficio instances");
		return categoriaBeneficioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public CategoriaBeneficio save(CategoriaBeneficio entity) throws Exception {
		log.debug("saving CategoriaBeneficio instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("CategoriaBeneficio");
		}

		validate(entity);

		if (categoriaBeneficioRepository.existsById(entity.getIdcat())) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return categoriaBeneficioRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(CategoriaBeneficio entity) throws Exception {
		log.debug("deleting CategoriaBeneficio instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("CategoriaBeneficio");
		}

		if (entity.getIdcat() == null) {
			throw new ZMessManager().new EmptyFieldException("idcat");
		}

		if (categoriaBeneficioRepository.existsById(entity.getIdcat()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		findById(entity.getIdcat()).ifPresent(entidad -> {
			List<Beneficios> beneficioses = entidad.getBeneficioses();
			if (Utilities.validationsList(beneficioses) == true) {
				throw new ZMessManager().new DeletingException("beneficioses");
			}
		});

		categoriaBeneficioRepository.deleteById(entity.getIdcat());
		log.debug("delete CategoriaBeneficio successful");

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		log.debug("deleting CategoriaBeneficio instance");
		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("idcat");
		}
		if (categoriaBeneficioRepository.existsById(id)) {
			delete(categoriaBeneficioRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public CategoriaBeneficio update(CategoriaBeneficio entity) throws Exception {

		log.debug("updating CategoriaBeneficio instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("CategoriaBeneficio");
		}

		validate(entity);

		if (categoriaBeneficioRepository.existsById(entity.getIdcat()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return categoriaBeneficioRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<CategoriaBeneficio> findById(Integer idcat) throws Exception {
		log.debug("getting CategoriaBeneficio instance");
		return categoriaBeneficioRepository.findById(idcat);
	}

}
