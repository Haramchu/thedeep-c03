package apap.tutorial.manpromanpro.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import apap.tutorial.manpromanpro.model.Proyek;

@Repository
public interface ProyekDb extends JpaRepository<Proyek, UUID> {
    @Query("SELECT p FROM Proyek p ORDER BY LOWER(p.nama) ASC")
    List<Proyek> findAllSortedByNameAsc();

    @Query("SELECT p FROM Proyek p ORDER BY LOWER(p.nama) DESC")
    List<Proyek> findAllSortedByNameDesc();
}