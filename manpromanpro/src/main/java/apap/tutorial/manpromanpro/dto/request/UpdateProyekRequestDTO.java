package apap.tutorial.manpromanpro.dto.request;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateProyekRequestDTO extends AddProyekRequestDTO {
    private UUID id;
}

