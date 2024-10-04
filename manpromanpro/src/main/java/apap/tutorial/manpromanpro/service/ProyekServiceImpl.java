package apap.tutorial.manpromanpro.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import apap.tutorial.manpromanpro.repository.ProyekDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import apap.tutorial.manpromanpro.model.Pekerja;
import apap.tutorial.manpromanpro.model.Proyek;

@Service
public class ProyekServiceImpl implements ProyekService {
    @Autowired
    ProyekDb proyekDb;

    @Override
    public Proyek addProyek(Proyek proyek) {
        return proyekDb.save(proyek);
    }

    @Override
    public List<Proyek> getAllProyek() {
        return proyekDb.findAll().stream()
                .filter(proyek -> proyek.getDeletedAt() == null)
                .toList();
    }

    @Override
    public Proyek getProyekById(UUID idProyek) {
        Optional<Proyek> proyek = proyekDb.findById(idProyek);
        if (proyek.isPresent() && proyek.get().getDeletedAt() == null) {
            return proyek.get();
        }
        return null;
    }
    

    @Override
    public Proyek updateProyek(Proyek proyek) {
        Proyek getProyek = getProyekById(proyek.getId());
        if (getProyek != null) {
            getProyek.setNama(proyek.getNama());
            getProyek.setDeskripsi(proyek.getDeskripsi());
            getProyek.setTanggalMulai(proyek.getTanggalMulai());
            getProyek.setTanggalSelesai(proyek.getTanggalSelesai());
            getProyek.setStatus(proyek.getStatus());
            getProyek.setDeveloper(proyek.getDeveloper());
            getProyek.setUpdatedAt(proyek.getUpdatedAt());
            proyekDb.save(getProyek);

            return getProyek;
        }

        return null;
    }

    @Override
    public void deleteProyek(Proyek proyek) {
        proyek.setDeletedAt(new Date());
        proyekDb.save(proyek);
    }

    @Override
    public List<Proyek> getAllProyek(String nama, String status, Sort sort) {
        if (!nama.isEmpty() && !status.isEmpty()) {
            return proyekDb.findByNamaIgnoreCaseContainingAndStatusIgnoreCaseAndDeletedAtIsNull(nama, status, sort);
        } else if (!nama.isEmpty()) {
            return proyekDb.findByNamaIgnoreCaseContainingAndDeletedAtIsNull(nama, sort);
        } else if (!status.isEmpty()) {
            return proyekDb.findByStatusIgnoreCaseAndDeletedAtIsNull(status, sort);
        } else {
            return proyekDb.findAllByDeletedAtIsNull(sort);
        }
    }
}