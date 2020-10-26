package co.com.coomeva.coben.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.coomeva.coben.domain.TipoDocumento;

/**
 * Interface for TipoDocumentoRepository.
 *
 */
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
}
