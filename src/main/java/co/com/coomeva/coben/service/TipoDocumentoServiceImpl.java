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
import co.com.coomeva.coben.domain.TipoDocumento;
import co.com.coomeva.coben.exception.ZMessManager;
import co.com.coomeva.coben.repository.TipoDocumentoRepository;
import co.com.coomeva.coben.utility.Utilities;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
@Slf4j
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;

	@Autowired
	private Validator validator;

	@Override
	public void validate(TipoDocumento tipoDocumento) throws ConstraintViolationException {

		Set<ConstraintViolation<TipoDocumento>> constraintViolations = validator.validate(tipoDocumento);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return tipoDocumentoRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoDocumento> findAll() {
		log.debug("finding all TipoDocumento instances");
		return tipoDocumentoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public TipoDocumento save(TipoDocumento entity) throws Exception {
		log.debug("saving TipoDocumento instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("TipoDocumento");
		}

		validate(entity);

		if (tipoDocumentoRepository.existsById(entity.getIdtipo())) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return tipoDocumentoRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(TipoDocumento entity) throws Exception {
		log.debug("deleting TipoDocumento instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("TipoDocumento");
		}

		if (entity.getIdtipo() == null) {
			throw new ZMessManager().new EmptyFieldException("idtipo");
		}

		if (tipoDocumentoRepository.existsById(entity.getIdtipo()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		findById(entity.getIdtipo()).ifPresent(entidad -> {
			List<Asociado> asociados = entidad.getAsociados();
			if (Utilities.validationsList(asociados) == true) {
				throw new ZMessManager().new DeletingException("asociados");
			}
		});

		tipoDocumentoRepository.deleteById(entity.getIdtipo());
		log.debug("delete TipoDocumento successful");

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		log.debug("deleting TipoDocumento instance");
		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("idtipo");
		}
		if (tipoDocumentoRepository.existsById(id)) {
			delete(tipoDocumentoRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public TipoDocumento update(TipoDocumento entity) throws Exception {

		log.debug("updating TipoDocumento instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("TipoDocumento");
		}

		validate(entity);

		if (tipoDocumentoRepository.existsById(entity.getIdtipo()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return tipoDocumentoRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TipoDocumento> findById(Integer idtipo) throws Exception {
		log.debug("getting TipoDocumento instance");
		return tipoDocumentoRepository.findById(idtipo);
	}

}
