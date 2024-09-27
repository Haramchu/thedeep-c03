package apap.tutorial.manpromanpro.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.manpromanpro.dto.request.AddProyekRequestDTO;
import apap.tutorial.manpromanpro.dto.request.UpdateProyekRequestDTO;
import apap.tutorial.manpromanpro.model.Developer;
import apap.tutorial.manpromanpro.model.Pekerja;
import apap.tutorial.manpromanpro.model.Proyek;
import apap.tutorial.manpromanpro.service.DeveloperService;
import apap.tutorial.manpromanpro.service.PekerjaService;
import apap.tutorial.manpromanpro.service.ProyekService;
import jakarta.validation.Valid;

@Controller
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @Autowired
    private DeveloperService developerService;

    @Autowired
    private PekerjaService pekerjaService;

    enum StatusLevel {
        STARTED,
        ONGOING,
        FINISHED,
    }

    @GetMapping("/")
    private String home(Model model) {
        model.addAttribute("page", "beranda");
        return "home";
    }

    @GetMapping("/proyek/add")
    public String addProyekForm(Model model) {
        model.addAttribute("page", "proyek");
        var proyekDTO = new AddProyekRequestDTO();

        model.addAttribute("proyekDTO", proyekDTO);
        model.addAttribute("listDeveloper", developerService.getAllDeveloper());
        model.addAttribute("statusLevel", StatusLevel.values());
        model.addAttribute("listPekerjaExisting", pekerjaService.getAllPekerja());

        return "form-add-proyek";
    }

    @PostMapping("/proyek/add")
    public String addProyek(@ModelAttribute @Valid AddProyekRequestDTO proyekDTO, BindingResult bindingResult,
            Model model) {
        model.addAttribute("page", "proyek");
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "fail-add-proyek";
        }

        var proyek = new Proyek();
        proyek.setNama(proyekDTO.getNama());
        proyek.setDeskripsi(proyekDTO.getDeskripsi());
        proyek.setTanggalMulai(proyekDTO.getTanggalMulai());
        proyek.setTanggalSelesai(proyekDTO.getTanggalSelesai());
        proyek.setStatus(proyekDTO.getStatus());
        proyek.setDeveloper(proyekDTO.getDeveloper());
        proyek.setListPekerja(proyekDTO.getListPekerja());

        proyekService.addProyek(proyek);

        model.addAttribute("responseMessage",
                String.format("Proyek %s dengan ID %s berhasil ditambahkan.", proyek.getNama(), proyek.getId()));

        return "response-proyek";
    }

    @GetMapping("/proyek/viewall")
    public String viewAllProyek(
            @RequestParam(name = "nama", required = false, defaultValue = "") String nama,
            @RequestParam(name = "status", required = false, defaultValue = "") String status,
            Model model) {
        model.addAttribute("page", "proyek");
        Sort sort = Sort.by(Sort.Order.asc("nama").ignoreCase());

        List<Proyek> listProyek = proyekService.getAllProyek(nama, status, sort);
        model.addAttribute("listProyek", listProyek);
        model.addAttribute("nama", nama);
        model.addAttribute("status", status);

        return "viewall-proyek";
    }

    @GetMapping("/proyek/{id}")
    public String detailProyek(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("page", "proyek");
        var proyek = proyekService.getProyekById(id);

        model.addAttribute("proyek", proyek);

        return "view-proyek";
    }

    @GetMapping("/proyek/{id}/update")
    public String updateProyek(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("page", "proyek");
        var proyek = proyekService.getProyekById(id);

        var proyekDTO = new UpdateProyekRequestDTO();
        proyekDTO.setId(proyek.getId());
        proyekDTO.setNama(proyek.getNama());
        proyekDTO.setDeskripsi(proyek.getDeskripsi());
        proyekDTO.setTanggalMulai(proyek.getTanggalMulai());
        proyekDTO.setTanggalSelesai(proyek.getTanggalSelesai());
        proyekDTO.setStatus(proyek.getStatus());
        proyekDTO.setDeveloper(proyek.getDeveloper());
        proyekDTO.setListPekerja(proyek.getListPekerja());

        model.addAttribute("proyekDTO", proyekDTO);
        model.addAttribute("listDeveloper", developerService.getAllDeveloper());
        model.addAttribute("statusLevel", StatusLevel.values());
        model.addAttribute("listPekerjaExisting", pekerjaService.getAllPekerja());

        return "form-update-proyek";
    }

    @PostMapping("/proyek/update")
    public String updateProyek(@Valid @ModelAttribute("proyekDTO") UpdateProyekRequestDTO proyekDTO,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listPekerjaExisting", pekerjaService.getAllPekerja());
            model.addAttribute("listDeveloper", developerService.getAllDeveloper());
            model.addAttribute("statusLevel", StatusLevel.values());
            return "form-update-proyek";
        }

        var proyekFromDTO = proyekService.getProyekById(proyekDTO.getId());
        Developer developer = developerService.getDeveloperById(proyekDTO.getDeveloper().getId());
        proyekFromDTO.setNama(proyekDTO.getNama());
        proyekFromDTO.setDeskripsi(proyekDTO.getDeskripsi());
        proyekFromDTO.setTanggalMulai(proyekDTO.getTanggalMulai());
        proyekFromDTO.setTanggalSelesai(proyekDTO.getTanggalSelesai());
        proyekFromDTO.setStatus(proyekDTO.getStatus());
        proyekFromDTO.setDeveloper(developer);
        proyekFromDTO.getListPekerja().retainAll(Collections.emptyList());
        Optional.ofNullable(proyekDTO.getListPekerja())
                .orElse(Collections.emptyList())
                .stream()
                .map(pekerja -> pekerjaService.getPekerjaById(pekerja.getId()))
                .filter(Objects::nonNull)
                .forEach(existingPekerja -> {
                    proyekFromDTO.getListPekerja().add(existingPekerja);
                    existingPekerja.getListProyek().add(proyekFromDTO);
                });

        proyekService.updateProyek(proyekFromDTO);
        model.addAttribute("responseMessage",
                String.format("Proyek %s dengan ID %s berhasil diupdate.", proyekFromDTO.getNama(),
                        proyekFromDTO.getId()));

        return "response-proyek";
    }

    @GetMapping("/proyek/{id}/delete")
    public String deleteProyek(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("page", "proyek");
        
        var proyek = proyekService.getProyekById(id);
        for(Pekerja pekerja: proyek.getListPekerja()){
            pekerja.getListProyek().remove(proyek);
        }
        proyekService.deleteProyek(proyek);

        model.addAttribute("responseMessage",
                String.format("Proyek %s dengan ID %s berhasil dihapus.", proyek.getNama(), proyek.getId()));

        return "response-proyek";
    }

    @PostMapping(value = "/proyek/add", params = { "addRow" })
    public String addRowDeveloperProyek(@ModelAttribute AddProyekRequestDTO addProyekRequestDTO, Model model) {
        model.addAttribute("page", "proyek");
        if (addProyekRequestDTO.getListPekerja() == null || addProyekRequestDTO.getListPekerja().isEmpty()) {
            addProyekRequestDTO.setListPekerja(new ArrayList<>());
        }

        addProyekRequestDTO.getListPekerja().add(new Pekerja());

        model.addAttribute("listPekerjaExisting", pekerjaService.getAllPekerja());
        model.addAttribute("listDeveloper", developerService.getAllDeveloper());
        model.addAttribute("proyekDTO", addProyekRequestDTO);
        model.addAttribute("statusLevel", StatusLevel.values());

        return "form-add-proyek";
    }

    @PostMapping(value = "/proyek/add", params = { "deleteRow" })
    public String deleteRowDeveloperProyek(@ModelAttribute AddProyekRequestDTO addProyekRequestDTO,
            @RequestParam("deleteRow") int row,
            Model model) {
        model.addAttribute("page", "proyek");
        addProyekRequestDTO.getListPekerja().remove(row);

        model.addAttribute("listPekerjaExisting", pekerjaService.getAllPekerja());
        model.addAttribute("listDeveloper", developerService.getAllDeveloper());
        model.addAttribute("proyekDTO", addProyekRequestDTO);
        model.addAttribute("statusLevel", StatusLevel.values());

        return "form-add-proyek";
    }

    @PostMapping(value = "/proyek/update", params = { "addRow" })
    public String addRowPekerjaUpdateProyek(@ModelAttribute UpdateProyekRequestDTO proyekDTO, Model model) {
        model.addAttribute("page", "proyek");
        if (proyekDTO.getListPekerja() == null || proyekDTO.getListPekerja().isEmpty()) {
            proyekDTO.setListPekerja(new ArrayList<>());
        }

        proyekDTO.getListPekerja().add(new Pekerja());

        model.addAttribute("listPekerjaExisting", pekerjaService.getAllPekerja());
        model.addAttribute("listDeveloper", developerService.getAllDeveloper());
        model.addAttribute("proyekDTO", proyekDTO);
        model.addAttribute("statusLevel", StatusLevel.values());

        return "form-update-proyek";
    }

    @PostMapping(value = "/proyek/update", params = { "deleteRow" })
    public String deleteRowPekerjaUpdateProyek(@ModelAttribute UpdateProyekRequestDTO proyekDTO,
            @RequestParam("deleteRow") int row, Model model) {
        model.addAttribute("page", "proyek");
        proyekDTO.getListPekerja().remove(row);

        model.addAttribute("listPekerjaExisting", pekerjaService.getAllPekerja());
        model.addAttribute("listDeveloper", developerService.getAllDeveloper());
        model.addAttribute("proyekDTO", proyekDTO);
        model.addAttribute("statusLevel", StatusLevel.values());

        return "form-update-proyek";
    }

    @GetMapping("proyek/datatable")
    public String getDatatable(Model model) {
        model.addAttribute("page", "proyek");
        List<Proyek> listProyek = proyekService.getAllProyek();
        model.addAttribute("listProyek", listProyek);
        return "datatable-proyek";
    }
    

}