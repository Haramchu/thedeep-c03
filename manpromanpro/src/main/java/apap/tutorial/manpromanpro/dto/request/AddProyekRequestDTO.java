package apap.tutorial.manpromanpro.dto.request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import apap.tutorial.manpromanpro.model.Developer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddProyekRequestDTO {
    private String nama;
    private String deskripsi;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalMulai;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalSelesai;

    private String status;
    private Developer developer;
}
