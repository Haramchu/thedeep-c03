package apap.tutorial.manpromanpro.restservice;

import apap.tutorial.manpromanpro.restdto.response.DeveloperOptionResponseDTO;
import java.util.List;

public interface DeveloperRestService {
    List<DeveloperOptionResponseDTO> getAllDevelopers();
}