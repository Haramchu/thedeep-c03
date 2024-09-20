package apap.tutorial.manpromanpro.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;

import apap.tutorial.manpromanpro.model.Proyek;

public interface ProyekService {
    Proyek addProyek(Proyek proyek);

    List<Proyek> getAllProyek();

    Proyek getProyekById(UUID idProyek);

    Proyek updateProyek(Proyek proyek);

    void deleteProyek(Proyek proyek);

    List<Proyek> getAllProyek(String nama, String status, Sort sort);
}

