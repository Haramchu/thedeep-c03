package apap.tutorial.manpromanpro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import apap.tutorial.manpro.manpro.model.Proyek;

@Service
public class ProyekServiceImpl implements ProyekService {
    private List<Proyek> listProyek = new ArrayList<Proyek>();

    @Override
    public void createProyek(Proyek proyek) {
        listProyek.add(proyek);
    }

    @Override
    public List<Proyek> getAllProyek() {
        return listProyek;
    }

    @Override
    public Proyek getProyekById(UUID id){
        List<Proyek> listProyek = getAllProyek();
        for (Proyek proyek: listProyek){
            if (proyek.getId() == id){
                return proyek;
            }
        }
        return null;
    }
}