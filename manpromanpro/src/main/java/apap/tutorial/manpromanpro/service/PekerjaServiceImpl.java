package apap.tutorial.manpromanpro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import apap.tutorial.manpromanpro.model.Pekerja;
import apap.tutorial.manpromanpro.model.Proyek;
import apap.tutorial.manpromanpro.repository.PekerjaDb;
import apap.tutorial.manpromanpro.repository.ProyekDb;

@Service
public class PekerjaServiceImpl implements PekerjaService {

    @Autowired
    PekerjaDb pekerjaDb;

    @Autowired
    ProyekDb proyekDb;

    @Override
    public Pekerja addPekerja(Pekerja pekerja) {
        return pekerjaDb.save(pekerja);
    }

    @Override
    public List<Pekerja> getAllPekerja() {
        return pekerjaDb.findAllByDeletedAtIsNull();
    }

    @Override
    public void deleteListPekerja(List<Pekerja> listPekerja) {
        if (listPekerja != null) {
            for (Pekerja pekerja : listPekerja) {
                if (pekerja.getListProyek() != null && !pekerja.getListProyek().isEmpty()) {
                    throw new RuntimeException("Pekerja is associated with a Proyek and cannot be deleted.");
                } else {
                    pekerja.setDeletedAt(new Date());
                    pekerjaDb.save(pekerja);
                }
            }
        }
    }

    @Override
    public Pekerja getPekerjaById(Long id){
        Optional<Pekerja> pekerja = pekerjaDb.findById(id);
        return pekerja.orElse(null);
    }

    @Override
    public void softDeletePekerja(Pekerja pekerja) {
        pekerja.setDeletedAt(new Date());
        pekerjaDb.save(pekerja);
    }
}
