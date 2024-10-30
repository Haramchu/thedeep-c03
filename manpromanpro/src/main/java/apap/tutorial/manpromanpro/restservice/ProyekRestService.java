package apap.tutorial.manpromanpro.restservice;

import apap.tutorial.manpromanpro.restdto.request.AddProyekRequestRestDTO;
import apap.tutorial.manpromanpro.restdto.response.ProyekResponseDTO;
import apap.tutorial.manpromanpro.restdto.request.UpdateProyekRequestRestDTO;

import java.util.UUID;

public interface ProyekRestService {
    ProyekResponseDTO addProyek(AddProyekRequestRestDTO proyekDTO);

    ProyekResponseDTO getProyekById(UUID idProyek);

    ProyekResponseDTO updateProyekRest(UpdateProyekRequestRestDTO proyekDTO);

    void deleteProyek(UUID idProyek);
}