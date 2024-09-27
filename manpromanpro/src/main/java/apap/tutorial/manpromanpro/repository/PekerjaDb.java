package apap.tutorial.manpromanpro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.tutorial.manpromanpro.model.Pekerja;

@Repository
public interface PekerjaDb extends JpaRepository<Pekerja, Long> {
    List<Pekerja> findByIsDeletedFalse();
}
