package apap.tutorial.manpromanpro.controller;

import apap.tutorial.manpromanpro.model.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import apap.tutorial.manpromanpro.dto.request.AddDeveloperRequestDTO;
import apap.tutorial.manpromanpro.service.DeveloperService;
import apap.tutorial.manpromanpro.service.ProyekService;

@Controller
public class DeveloperController {

    @Autowired
    DeveloperService developerService;

    @Autowired
    ProyekService proyekService;

    @GetMapping("/developer/add")
    public String formAddDeveloper(Model model) {
        var developerDTO = new AddDeveloperRequestDTO();

        model.addAttribute("developerDTO", developerDTO);

        return "form-add-developer";
    }

    @PostMapping("/developer/add")
    public String addDeveloper(@ModelAttribute("developerDTO") AddDeveloperRequestDTO developerDTO, Model model) {
        var developer = new Developer();
        developer.setNama(developerDTO.getNama());
        developer.setAlamat(developerDTO.getAlamat());
        developer.setTanggalBerdiri(developerDTO.getTanggalBerdiri());
        developer.setEmail(developerDTO.getEmail());

        developerService.addDeveloper(developer);

        model.addAttribute("responseMessage",
                String.format("Developer %s dengan ID %s berhasil ditambahkan.", developer.getNama(), developer.getId()));
        return "response-developer";
    }

    @GetMapping("/developer/viewall")
    public String listDeveloper(Model model) {
        var listDeveloper = developerService.getAllDeveloper();

        model.addAttribute("listDeveloper", listDeveloper);
        return "viewall-developer";
    }

    @GetMapping("/developer/{id}")
    public String detailDeveloper(@PathVariable("id") Long id, Model model) {
        var developer = developerService.getDeveloperById(id);

        model.addAttribute("developer", developer);
        return "view-developer";
    }
}