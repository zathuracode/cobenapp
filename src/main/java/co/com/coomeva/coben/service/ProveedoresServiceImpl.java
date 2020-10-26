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
import co.com.coomeva.coben.domain.Proveedores;
import co.com.coomeva.coben.exception.ZMessManager;
import co.com.coomeva.coben.repository.ProveedoresRepository;
import co.com.coomeva.coben.utility.Utilities;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
@Slf4j
public class ProveedoresServiceImpl implements ProveedoresService {

	@Autowired
	private ProveedoresRepository proveedoresRepository;

	@Autowired
	private Validator validator;

	@Override
	public void validate(Proveedores proveedores) throws ConstraintViolationException {

		Set<ConstraintViolation<Proveedores>> constraintViolations = validator.validate(proveedores);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return proveedoresRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Proveedores> findAll() {
		log.debug("finding all Proveedores instances");
		return proveedoresRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Proveedores save(Proveedores entity) throws Exception {
		log.debug("saving Proveedores instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Proveedores");
		}

		validate(entity);

		if (proveedoresRepository.existsById(entity.getIdprovd())) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return proveedoresRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Proveedores entity) throws Exception {
		log.debug("deleting Proveedores instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Proveedores");
		}

		if (entity.getIdprovd() == null) {
			throw new ZMessManager().new EmptyFieldException("idprovd");
		}

		if (proveedoresRepository.existsById(entity.getIdprovd()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		findById(entity.getIdprovd()).ifPresent(entidad -> {
			List<Beneficios> beneficioses = entidad.getBeneficioses();
			if (Utilities.validationsList(beneficioses) == true) {
				throw new ZMessManager().new DeletingException("beneficioses");
			}
		});

		proveedoresRepository.deleteById(entity.getIdprovd());
		log.debug("delete Proveedores successful");

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		log.debug("deleting Proveedores instance");
		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("idprovd");
		}
		if (proveedoresRepository.existsById(id)) {
			delete(proveedoresRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Proveedores update(Proveedores entity) throws Exception {

		log.debug("updating Proveedores instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Proveedores");
		}

		validate(entity);

		if (proveedoresRepository.existsById(entity.getIdprovd()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return proveedoresRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Proveedores> findById(Integer idprovd) throws Exception {
		log.debug("getting Proveedores instance");
		return proveedoresRepository.findById(idprovd);
	}

}
