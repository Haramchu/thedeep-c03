package apap.tutorial.manpromanpro.service;

import java.util.List;
import java.uitl.UUID;

import apap.tutorial.manpromanpro.Proyek;

public interface ProyekService {
    Void CreateProyek (Proyek proyek);

    List<Proyek> getallProyek();

    Proyek getProyekByID(UUID id);
}
