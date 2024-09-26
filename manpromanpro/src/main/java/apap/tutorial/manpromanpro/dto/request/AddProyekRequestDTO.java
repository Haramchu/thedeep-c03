package apap.tutorial.manpromanpro.dto.request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import apap.tutorial.manpromanpro.model.Developer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddProyekRequestDTO {
    @NotBlank(message = "Nama proyek tidak boleh kosong")
    @Size(min = 3, max = 50, message = "Nama proyek harus lebih dari 3 huruf dan kurang dari 50 huruf")
    private String nama;

    @NotBlank(message = "Deskripsi proyek tidak boleh kosong")
    private String deskripsi;

    @NotNull(message = "Tanggal mulai tidak boleh kosong")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalMulai;

    @NotNull(message = "Tanggal selesai tidak boleh kosong")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalSelesai;

    @NotBlank(message = "Status tidak boleh kosong")
    private String status;
    
    private Developer developer;
}
