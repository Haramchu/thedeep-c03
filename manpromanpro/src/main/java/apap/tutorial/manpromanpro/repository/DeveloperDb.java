package apap.tutorial.manpromanpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.tutorial.manpromanpro.model.Developer;

@Repository
public interface DeveloperDb extends JpaRepository<Developer, Long> {

}
