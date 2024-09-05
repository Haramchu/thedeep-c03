package com.tutorial.romanconverter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tutorial.romanconverter.dto.IntegerRequestDTO;
import com.tutorial.romanconverter.dto.RequestDTO;
import com.tutorial.romanconverter.model.IntegerConverter;
import com.tutorial.romanconverter.model.RomanConverter;

@Controller
public class IntegerConverterController {

    @GetMapping(value = "/convert-integer")
    public String getIntegerConverterForm(Model model) {
        // Initialize the form with IntegerRequestDTO object
        model.addAttribute("integerRequestDTO", new IntegerRequestDTO());
        return "form-integer-converter.html"; // This is the form page for integer conversion
    }

    @PostMapping(value = "/convert-integer")
    public String postIntegerConverterForm(
            @ModelAttribute IntegerRequestDTO integerRequestDTO, Model model) {

        // Get the integer from the form
        int number = Integer.parseInt(integerRequestDTO.getInteger());

        // Convert the integer to Roman numeral
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
