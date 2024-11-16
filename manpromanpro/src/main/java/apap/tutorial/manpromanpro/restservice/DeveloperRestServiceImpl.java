package apap.tutorial.manpromanpro.restservice;

import apap.tutorial.manpromanpro.restdto.response.DeveloperOptionResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tutorial.manpromanpro.model.Developer;
import apap.tutorial.manpromanpro.repository.DeveloperDb;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;

@Service
@Transactional
public class DeveloperRestServiceImpl implements DeveloperRestService {
    @Autowired
    DeveloperDb developerDb;

    @Override
    public List<DeveloperOptionResponseDTO> getAllDevelopers() {
        List<Developer> developers = developerDb.findAll();

        List<DeveloperOptionResponseDTO> developerOptions = new ArrayList<>();
        developers.forEach(developer -> developerOptions.add(developerToDeveloperOptionResponseDTO(developer)));

        return developerOptions;
    }

    private DeveloperOptionResponseDTO developerToDeveloperOptionResponseDTO(Developer developer) {
        DeveloperOptionResponseDTO developerOptionResponseDTO = new DeveloperOptionResponseDTO();
        developerOptionResponseDTO.setId(developer.getId());
        developerOptionResponseDTO.setNama(developer.getNama());

        return developerOptionResponseDTO;
    }
}