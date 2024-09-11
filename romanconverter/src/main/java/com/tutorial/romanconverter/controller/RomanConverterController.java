package com.tutorial.romanconverter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tutorial.romanconverter.dto.RequestDTO;
import com.tutorial.romanconverter.model.RomanConverter;

import java.util.regex.Pattern;

@Controller
public class RomanConverterController {

    private static final Pattern ROMAN_NUMERAL_PATTERN = Pattern.compile("^[MDCLXVI]+$");

    @GetMapping(value = "/")
    public String home(Model model) {
        return "view-home.html";
    }

    private String getRomanConverterPage(String roman, Model model) {
        final RomanConverter romanConverter = new RomanConverter(roman);
        model.addAttribute("romanConverter", romanConverter);
        return "view-conversion-result.html";
    }

    private boolean isValidRomanNumeral(String roman) {
        return ROMAN_NUMERAL_PATTERN.matcher(roman).matches();
    }

    @GetMapping(value = "/roman-converter/{roman}")
    public String romanConverterWithPathVariable(@PathVariable(value = "roman") String roman, Model model) {
        if (!roman.equals(roman.toUpperCase()) || !isValidRomanNumeral(roman)) {
            return "view-wrong-input.html";
        }
        return getRomanConverterPage(roman, model);
    }

    @GetMapping(value = "/roman-converter")
    public String romanConverterWithReqParam(@RequestParam(value = "roman") String roman, Model model) {
        if (!roman.equals(roman.toUpperCase()) || !isValidRomanNumeral(roman)) {
            return "view-wrong-input.html";
        }
        return getRomanConverterPage(roman, model);
    }
    
    @GetMapping(value = "/convert")
    public String getRomanCoverterWithView(Model model) {
        var requestDTO = new RequestDTO();
        model.addAttribute("requestDTO", requestDTO);
        return "form.html";
    }

    @GetMapping(value = "/about-me")
    public String AboutMe(Model model) {
        String nama = "Clement";
        String npm = "2206082114";
        String usia = "20";
        String kelas = "APAP A";
        model.addAttribute("nama", nama);
        model.addAttribute("npm", npm);
        model.addAttribute("usia", usia);
        model.addAttribute("kelas", kelas);
        
        return "view-about-me.html";
    }

    @PostMapping(value = "/convert")
    public String postRomanConverterWithView(
        @ModelAttribute RequestDTO requestDTO, Model model
    ) {
        String romanFromView = requestDTO.getRoman();
        // If input is not uppercase or invalid, redirect to error page
        if (!romanFromView.equals(romanFromView.toUpperCase()) || !isValidRomanNumeral(romanFromView)) {
            return "view-wrong-input.html";
        }
        return getRomanConverterPage(romanFromView, model);
    }

}
