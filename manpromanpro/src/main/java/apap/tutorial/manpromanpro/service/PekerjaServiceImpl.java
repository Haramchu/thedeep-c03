package apap.tutorial.manpromanpro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import apap.tutorial.manpromanpro.model.Pekerja;
import apap.tutorial.manpromanpro.repository.PekerjaDb;

@Service
public class PekerjaServiceImpl implements PekerjaService {

    @Autowired
    PekerjaDb pekerjaDb;

    @Override
    public Pekerja addPekerja(Pekerja pekerja) {
        return pekerjaDb.save(pekerja);
    }

    @Override
    public List<Pekerja> getAllPekerja() {
        return pekerjaDb.findByIsDeletedFalse();
    }

    @Override
    public void deleteListPekerja(List<Pekerja> listPekerja) {
        if (listPekerja != null) {
            for (Pekerja pekerja : listPekerja) {
                if (pekerja.getListProyek() == null || pekerja.getListProyek().isEmpty()) {
                    pekerja.setDeleted(true);
                    pekerjaDb.save(pekerja);
                }
            }
        }
    }
}
