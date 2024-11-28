package com.tutorial.romanconverter.dto.rest;

import lombok.Data;

@Data
public class RestFailedResponseDTO {
    private final String error = "Masukan tidak valid";
}
