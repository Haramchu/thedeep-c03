package com.tutorial.romanconverter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tutorial.romanconverter.dto.rest.RestFailedResponseDTO;
import com.tutorial.romanconverter.dto.rest.RestSuccessResponseDTO;
import com.tutorial.romanconverter.model.IntegerConverter;
import com.tutorial.romanconverter.model.RomanConverter;

@RestController()
@RequestMapping("/api")
public class ConverterRestController {
    
    @GetMapping(value = "convert-roman/{roman}")
    public ResponseEntity<?> convertRomanWithGet(@PathVariable String roman) {
        try {
            RomanConverter romanConverter = new RomanConverter(roman);
            RestSuccessResponseDTO successResponse = new RestSuccessResponseDTO();
            successResponse.setRoman(roman);
            successResponse.setInteger(romanConverter.convertRomanToDecimal());
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new RestFailedResponseDTO(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping(value = "convert-integer/{integer}")
    public ResponseEntity<?> convertIntegerWithGet(@PathVariable String integer) {
        try {
            int intFromPath = Integer.parseInt(integer);
            IntegerConverter integerConverter = new IntegerConverter(intFromPath);
            RestSuccessResponseDTO successResponse = new RestSuccessResponseDTO();
            successResponse.setRoman(integerConverter.convertIntegerToRoman());
            successResponse.setInteger(intFromPath);
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new RestFailedResponseDTO(), HttpStatus.BAD_REQUEST);
        }
    }
}
