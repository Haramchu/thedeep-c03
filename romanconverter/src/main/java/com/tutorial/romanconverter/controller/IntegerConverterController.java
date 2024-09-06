package com.tutorial.romanconverter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tutorial.romanconverter.dto.IntegerRequestDTO;
import com.tutorial.romanconverter.model.IntegerConverter;

@Controller
public class IntegerConverterController {

    @GetMapping(value = "/convert-integer")
    public String getIntegerConverterForm(Model model) {
        model.addAttribute("integerRequestDTO", new IntegerRequestDTO());
        return "form-integer-converter.html"; 
    }

    @PostMapping(value = "/convert-integer")
    public String postIntegerConverterForm(
            @ModelAttribute IntegerRequestDTO integerRequestDTO, Model model) {

        int number = Integer.parseInt(integerRequestDTO.getInteger());

        IntegerConverter integerConverter = new IntegerConverter(number);
        model.addAttribute("integerConverter", integerConverter);

        return getIntegerConverterPage(number, model);

    }

    private String  getIntegerConverterPage(Integer number, Model model) {
        final IntegerConverter IntegerConverter = new IntegerConverter(number);
        model.addAttribute("integerConverter", IntegerConverter);
        return "view-conversion-result-integer.html";
    }
}
