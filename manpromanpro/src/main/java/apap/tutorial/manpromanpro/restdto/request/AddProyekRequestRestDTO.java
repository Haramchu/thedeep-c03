package apap.tutorial.manpromanpro.restdto.request;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddProyekRequestRestDTO {
    @NotBlank(message = "Nama proyek tidak boleh kosong")
    @Size(max = 30, message = "Nama proyek tidak boleh lebih dari 30 karakter")
    private String nama;

    @NotBlank(message = "Deskripsi proyek tidak boleh kosong")
    private String deskripsi;

    @NotNull(message = "Tanggal mulai tidak boleh kosong")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalMulai;

    @NotNull(message = "Tanggal selesai tidak boleh kosong")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalSelesai;

    @NotNull(message = "Developer proyek tidak boleh kosong")
    private Long developer;

    private List<Long> listPekerja;

    @NotBlank(message = "Status tidak boleh kosong")
    @Pattern(regexp = "STARTED|ONGOING|FINISHED", message = "Status harus STARTED, ONGOING, atau FINISHED")
    private String status;

    @AssertTrue(message = "Tanggal selesai harus setelah tanggal mulai")
    private boolean isTanggalSelesaiValid() {
        if (tanggalMulai == null || tanggalSelesai == null) {
            return true;
        }
        return tanggalSelesai.after(tanggalMulai);
    }
}
