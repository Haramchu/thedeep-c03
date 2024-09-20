package apap.tutorial.manpromanpro.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.tutorial.manpromanpro.model.Proyek;

@Repository
public interface ProyekDb extends JpaRepository<Proyek, UUID> {
    
}