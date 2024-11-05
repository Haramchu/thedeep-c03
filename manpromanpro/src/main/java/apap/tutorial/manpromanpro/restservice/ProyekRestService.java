package apap.tutorial.manpromanpro.restservice;

import apap.tutorial.manpromanpro.restdto.request.AddProyekRequestRestDTO;
import apap.tutorial.manpromanpro.restdto.response.ProyekResponseDTO;
import apap.tutorial.manpromanpro.restdto.request.UpdateProyekRequestRestDTO;

import java.util.List;
import java.util.UUID;

public interface ProyekRestService {
    ProyekResponseDTO addProyek(AddProyekRequestRestDTO proyekDTO);

    ProyekResponseDTO getProyekById(UUID idProyek);

    ProyekResponseDTO updateProyekRest(UpdateProyekRequestRestDTO proyekDTO);
    
    List<ProyekResponseDTO> getProyekByNama(String nama);

    void deleteProyek(UUID idProyek);

    List<ProyekResponseDTO> getAllProyek();
}