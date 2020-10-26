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
import co.com.coomeva.coben.domain.Preferencias;
import co.com.coomeva.coben.domain.UbicacionBeneficio;
import co.com.coomeva.coben.domain.UsoBeneficio;
import co.com.coomeva.coben.exception.ZMessManager;
import co.com.coomeva.coben.repository.BeneficiosRepository;
import co.com.coomeva.coben.utility.Utilities;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
@Slf4j
public class BeneficiosServiceImpl implements BeneficiosService {

	@Autowired
	private BeneficiosRepository beneficiosRepository;

	@Autowired
	private Validator validator;

	@Override
	public void validate(Beneficios beneficios) throws ConstraintViolationException {

		Set<ConstraintViolation<Beneficios>> constraintViolations = validator.validate(beneficios);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return beneficiosRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Beneficios> findAll() {
		log.debug("finding all Beneficios instances");
		return beneficiosRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Beneficios save(Beneficios entity) throws Exception {
		log.debug("saving Beneficios instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Beneficios");
		}

		validate(entity);

		if (beneficiosRepository.existsById(entity.getIdbeneficio())) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return beneficiosRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Beneficios entity) throws Exception {
		log.debug("deleting Beneficios instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Beneficios");
		}

		if (entity.getIdbeneficio() == null) {
			throw new ZMessManager().new EmptyFieldException("idbeneficio");
		}

		if (beneficiosRepository.existsById(entity.getIdbeneficio()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		findById(entity.getIdbeneficio()).ifPresent(entidad -> {
			List<Preferencias> preferenciases = entidad.getPreferenciases();
			if (Utilities.validationsList(preferenciases) == true) {
				throw new ZMessManager().new DeletingException("preferenciases");
			}
			List<UbicacionBeneficio> ubicacionBeneficios = entidad.getUbicacionBeneficios();
			if (Utilities.validationsList(ubicacionBeneficios) == true) {
				throw new ZMessManager().new DeletingException("ubicacionBeneficios");
			}
			List<UsoBeneficio> usoBeneficios = entidad.getUsoBeneficios();
			if (Utilities.validationsList(usoBeneficios) == true) {
				throw new ZMessManager().new DeletingException("usoBeneficios");
			}
		});

		beneficiosRepository.deleteById(entity.getIdbeneficio());
		log.debug("delete Beneficios successful");

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		log.debug("deleting Beneficios instance");
		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("idbeneficio");
		}
		if (beneficiosRepository.existsById(id)) {
			delete(beneficiosRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Beneficios update(Beneficios entity) throws Exception {

		log.debug("updating Beneficios instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Beneficios");
		}

		validate(entity);

		if (beneficiosRepository.existsById(entity.getIdbeneficio()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return beneficiosRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Beneficios> findById(Integer idbeneficio) throws Exception {
		log.debug("getting Beneficios instance");
		return beneficiosRepository.findById(idbeneficio);
	}

}
