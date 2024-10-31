package apap.tutorial.manpromanpro.restservice;

import apap.tutorial.manpromanpro.restdto.request.AddProyekRequestRestDTO;
import apap.tutorial.manpromanpro.restdto.request.UpdateProyekRequestRestDTO;
import apap.tutorial.manpromanpro.restdto.response.DeveloperResponseDTO;
import apap.tutorial.manpromanpro.restdto.response.PekerjaResponseDTO;
import apap.tutorial.manpromanpro.restdto.response.ProyekResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import apap.tutorial.manpromanpro.model.Pekerja;
import apap.tutorial.manpromanpro.model.Proyek;
import apap.tutorial.manpromanpro.model.Developer;
import apap.tutorial.manpromanpro.repository.DeveloperDb;
import apap.tutorial.manpromanpro.repository.PekerjaDb;
import apap.tutorial.manpromanpro.repository.ProyekDb;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProyekRestServiceImpl implements ProyekRestService {

    @Autowired
    ProyekDb proyekDb;

    @Autowired
    PekerjaDb pekerjaDb;

    @Autowired
    DeveloperDb developerDb;

    @Override
    public ProyekResponseDTO addProyek(AddProyekRequestRestDTO proyekDTO) {
        Proyek proyek = new Proyek();
        proyek.setNama(proyekDTO.getNama());
        proyek.setDeskripsi(proyekDTO.getDeskripsi());
        proyek.setTanggalMulai(proyekDTO.getTanggalMulai());
        proyek.setTanggalSelesai(proyekDTO.getTanggalSelesai());
        proyek.setStatus(proyekDTO.getStatus());

        Developer developer = developerDb.findById(proyekDTO.getDeveloper())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Data developer tidak ditemukan"));
        proyek.setDeveloper(developer);

        proyek.setListPekerja(new ArrayList<>());

        if (proyekDTO.getListPekerja() != null) {
            proyekDTO.getListPekerja().forEach(idPekerja -> {
                Pekerja pekerja = pekerjaDb.findById(idPekerja)
                        .orElseThrow(() -> new EntityNotFoundException("Data pekerja tidak ditemukan"));

                pekerja.getListProyek().add(proyek);
                proyek.getListPekerja().add(pekerja);
            });
        }

        proyek.setCreatedAt(new Date());
        proyek.setUpdatedAt(new Date());

        Proyek savedProyek = proyekDb.save(proyek);

        return proyekToProyekResponseDTO(savedProyek);
    }

    @Override
    public ProyekResponseDTO getProyekById(UUID idProyek) {
        var proyek = proyekDb.findById(idProyek).orElse(null);

        if (proyek == null) {
            return null;
        }

        return proyekToProyekResponseDTO(proyek);
    }

    @Override
    public ProyekResponseDTO updateProyekRest(UpdateProyekRequestRestDTO proyekDTO) {
        Proyek proyek = proyekDb.findById(proyekDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Proyek tidak ditemukan"));

        proyek.setNama(proyekDTO.getNama());
        proyek.setDeskripsi(proyekDTO.getDeskripsi());
        proyek.setTanggalMulai(proyekDTO.getTanggalMulai());
        proyek.setTanggalSelesai(proyekDTO.getTanggalSelesai());
        proyek.setStatus(proyekDTO.getStatus());
        proyek.setUpdatedAt(new Date());

        if (proyekDTO.getDeveloper() != null) {
            Developer developer = developerDb.findById(proyekDTO.getDeveloper())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Developer tidak ditemukan"));
            proyek.setDeveloper(developer);
        }

        if (proyekDTO.getListPekerja() != null) {
            proyek.getListPekerja().forEach(pekerja -> {
                pekerja.getListProyek().remove(proyek);
            });
            proyek.getListPekerja().clear();

            proyekDTO.getListPekerja().forEach(idPekerja -> {
                Pekerja pekerja = pekerjaDb.findById(idPekerja)
                        .orElseThrow(() -> new EntityNotFoundException("Data pekerja tidak ditemukan"));
                pekerja.getListProyek().add(proyek);
                proyek.getListPekerja().add(pekerja);
            });
        }

        Proyek savedProyek = proyekDb.save(proyek);
        return proyekToProyekResponseDTO(savedProyek);
    }

    @Override
    public void deleteProyek(UUID idProyek) {
        var proyek = proyekDb.findById(idProyek)
                .orElseThrow(() -> new EntityNotFoundException("Data proyek tidak ditemukan"));
        proyek.setDeletedAt(new Date());
        proyekDb.save(proyek);
    }

    @Override
    public List<ProyekResponseDTO> getProyekByNama(String nama) {
        var listProyek = proyekDb.findByNamaIgnoreCaseContainingAndDeletedAtIsNull(nama, null);

        if (listProyek == null) {
            return null;
        }
        var listProyekResponseDTO = new ArrayList<ProyekResponseDTO>();
        listProyek.forEach(proyek -> {
            var proyekResponseDTO = proyekToProyekResponseDTO(proyek);
            listProyekResponseDTO.add(proyekResponseDTO);
        });

        return listProyekResponseDTO;
    }

    private ProyekResponseDTO proyekToProyekResponseDTO(Proyek proyek) {
        ProyekResponseDTO proyekResponseDTO = new ProyekResponseDTO();
        proyekResponseDTO.setId(proyek.getId());
        proyekResponseDTO.setNama(proyek.getNama());
        proyekResponseDTO.setDeskripsi(proyek.getDeskripsi());
        proyekResponseDTO.setTanggalMulai(proyek.getTanggalMulai());
        proyekResponseDTO.setTanggalSelesai(proyek.getTanggalSelesai());
        proyekResponseDTO.setStatus(proyek.getStatus());
        proyekResponseDTO.setDeveloper(developerToDeveloperResponseDTO(proyek.getDeveloper()));
        proyekResponseDTO.setDeletedAt(proyek.getDeletedAt());
        proyekResponseDTO.setCreatedAt(proyek.getCreatedAt());
        proyekResponseDTO.setUpdatedAt(proyek.getUpdatedAt());

        if (proyek.getListPekerja() != null) {
            List<PekerjaResponseDTO> listPekerjaResponseDTO = new ArrayList<>();
            proyek.getListPekerja().forEach(pekerja -> {
                PekerjaResponseDTO pekerjaResponseDTO = new PekerjaResponseDTO();
                pekerjaResponseDTO.setId(pekerja.getId());
                pekerjaResponseDTO.setNama(pekerja.getNama());
                pekerjaResponseDTO.setUsia(pekerja.getUsia());
                pekerjaResponseDTO.setPekerjaan(pekerja.getPekerjaan());
                pekerjaResponseDTO.setBiografi(pekerja.getBiografi());
                pekerjaResponseDTO.setCreatedAt(pekerja.getCreatedAt());
                pekerjaResponseDTO.setUpdatedAt(pekerja.getUpdatedAt());
                listPekerjaResponseDTO.add(pekerjaResponseDTO);
            });
            proyekResponseDTO.setListPekerja(listPekerjaResponseDTO);
        }

        return proyekResponseDTO;
    }

    private DeveloperResponseDTO developerToDeveloperResponseDTO(Developer developer) {
        DeveloperResponseDTO developerResponseDTO = new DeveloperResponseDTO();
        developerResponseDTO.setId(developer.getId());
        developerResponseDTO.setNama(developer.getNama());
        developerResponseDTO.setAlamat(developer.getAlamat());
        developerResponseDTO.setEmail(developer.getEmail());
        developerResponseDTO.setTanggalBerdiri(developer.getTanggalBerdiri());
        developerResponseDTO.setCreatedAt(developer.getCreatedAt());
        developerResponseDTO.setUpdatedAt(developer.getUpdatedAt());
        return developerResponseDTO;
    }

}