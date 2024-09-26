package apap.tutorial.manpromanpro.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateProyekRequestDTO extends AddProyekRequestDTO {
    @NotNull(message = "Id error")
    private UUID id;
}

