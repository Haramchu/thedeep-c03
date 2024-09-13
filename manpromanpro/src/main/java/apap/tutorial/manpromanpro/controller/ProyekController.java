package apap.tutorial.manpromanpro.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import apap.tutorial.manpromanpro.controller.DTO.ProyekDTO;
import apap.tutorial.manpromanpro.model.Proyek;
import apap.tutorial.manpromanpro.service.ProyekService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @GetMapping("/")
    private String home() {
        return "home";
    }

    @GetMapping("/proyek/add")
    public String addProyekForm(Model model) {
        var proyekDTO = new ProyekDTO();

        model.addAttribute("proyekDTO", proyekDTO);

        return "form-add-proyek";
    }

    @PostMapping("/proyek/add")
    public String addProyek(@ModelAttribute ProyekDTO proyekDTO, Model model) {
        if (proyekDTO.getTanggalMulai().after(proyekDTO.getTanggalSelesai())) {
            return "wrong-date-input"; 
        }
        UUID idProyek = UUID.randomUUID();
        var proyek = new Proyek(idProyek, proyekDTO.getNama(), proyekDTO.getTanggalMulai(),
                proyekDTO.getTanggalSelesai(), proyekDTO.getStatus(), proyekDTO.getDeveloper());
        proyekService.createProyek(proyek);
        model.addAttribute("id", proyek.getId());
        model.addAttribute("Nama", proyek.getNama());

        return "success-add-proyek";
    }

    @GetMapping("/proyek/viewall")
    public String listProyek(Model model) {

        List<Proyek> listProyek = proyekService.getAllProyek();

        model.addAttribute("listProyek", listProyek);

        return "view-all-proyek";
    }

    @GetMapping("/proyek")
    public String detailProyek(@RequestParam(value = "id") UUID id, Model model) {

        var proyek = proyekService.getProyekById(id);

        model.addAttribute("proyek", proyek);

        return "view-proyek";
    }

    @GetMapping(value = "/proyek/{id}/update")
    public String updateProyekForm(@PathVariable(value = "id") UUID id, Model model) {
        var proyek = proyekService.getProyekById(id);
        model.addAttribute("proyek", proyek);
        return "form-update-proyek";
    }

    @PostMapping("/proyek/update")
    public String updateProyek(@ModelAttribute ProyekDTO proyekDTO, Model model) {
        if (proyekDTO.getTanggalMulai().after(proyekDTO.getTanggalSelesai())) {
            return "wrong-date-input"; 
        }
        var existingProyek = proyekService.getProyekById(proyekDTO.getId());

        existingProyek.setNama(proyekDTO.getNama());
        existingProyek.setTanggalMulai(proyekDTO.getTanggalMulai());
        existingProyek.setTanggalSelesai(proyekDTO.getTanggalSelesai());
        existingProyek.setStatus(proyekDTO.getStatus());
        existingProyek.setDeveloper(proyekDTO.getDeveloper());

        model.addAttribute("id", existingProyek.getId());
        model.addAttribute("nama", existingProyek.getNama());

        return "success-update-proyek";
    }

    @GetMapping(value = "/proyek/{id}/delete")
    public String deleteProyek(@PathVariable(value = "id") UUID id, Model model) {
        Proyek proyek = proyekService.getProyekById(id);

        if (proyek != null) {
            proyekService.deleteProyek(id);
        } else {
        }

        return "success-delete-proyek";
    }
}