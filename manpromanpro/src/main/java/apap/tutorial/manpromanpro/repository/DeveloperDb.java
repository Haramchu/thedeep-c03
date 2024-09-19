package apap.tutorial.manpromanpro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.tutorial.manpromanpro.model.Developer;

@Repository
public interface DeveloperDb extends JpaRepository<Developer, Long> {
    List<Developer> findAll();

    Optional<Developer> findById(Long id);
}
