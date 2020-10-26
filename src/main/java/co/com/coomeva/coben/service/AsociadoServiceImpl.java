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

import co.com.coomeva.coben.domain.Asociado;
import co.com.coomeva.coben.domain.Preferencias;
import co.com.coomeva.coben.domain.UsoBeneficio;
import co.com.coomeva.coben.exception.ZMessManager;
import co.com.coomeva.coben.repository.AsociadoRepository;
import co.com.coomeva.coben.utility.Utilities;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
@Slf4j
public class AsociadoServiceImpl implements AsociadoService {

	@Autowired
	private AsociadoRepository asociadoRepository;

	@Autowired
	private Validator validator;

	@Override
	public void validate(Asociado asociado) throws ConstraintViolationException {

		Set<ConstraintViolation<Asociado>> constraintViolations = validator.validate(asociado);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return asociadoRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asociado> findAll() {
		log.debug("finding all Asociado instances");
		return asociadoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Asociado save(Asociado entity) throws Exception {
		log.debug("saving Asociado instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Asociado");
		}

		validate(entity);

		if (asociadoRepository.existsById(entity.getDocumento())) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return asociadoRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Asociado entity) throws Exception {
		log.debug("deleting Asociado instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Asociado");
		}

		if (entity.getDocumento() == null) {
			throw new ZMessManager().new EmptyFieldException("documento");
		}

		if (asociadoRepository.existsById(entity.getDocumento()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		findById(entity.getDocumento()).ifPresent(entidad -> {
			List<Preferencias> preferenciases = entidad.getPreferenciases();
			if (Utilities.validationsList(preferenciases) == true) {
				throw new ZMessManager().new DeletingException("preferenciases");
			}
			List<UsoBeneficio> usoBeneficios = entidad.getUsoBeneficios();
			if (Utilities.validationsList(usoBeneficios) == true) {
				throw new ZMessManager().new DeletingException("usoBeneficios");
			}
		});

		asociadoRepository.deleteById(entity.getDocumento());
		log.debug("delete Asociado successful");

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(String id) throws Exception {
		log.debug("deleting Asociado instance");
		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("documento");
		}
		if (asociadoRepository.existsById(id)) {
			delete(asociadoRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Asociado update(Asociado entity) throws Exception {

		log.debug("updating Asociado instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Asociado");
		}

		validate(entity);

		if (asociadoRepository.existsById(entity.getDocumento()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return asociadoRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Asociado> findById(String documento) throws Exception {
		log.debug("getting Asociado instance");
		return asociadoRepository.findById(documento);
	}

}
