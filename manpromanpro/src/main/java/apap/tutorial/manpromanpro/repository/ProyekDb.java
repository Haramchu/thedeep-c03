package apap.tutorial.manpromanpro.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.tutorial.manpromanpro.model.Proyek;

import org.springframework.data.domain.Sort;

@Repository
public interface ProyekDb extends JpaRepository<Proyek, UUID> {
    List<Proyek> findAllByDeletedAtIsNull(Sort sort);
    List<Proyek> findByStatusIgnoreCaseAndDeletedAtIsNull(String status, Sort sort);
    List<Proyek> findByNamaIgnoreCaseContainingAndDeletedAtIsNull(String nama, Sort sort);
    List<Proyek> findByNamaIgnoreCaseContainingAndStatusIgnoreCaseAndDeletedAtIsNull(String nama, String status, Sort sort);
}