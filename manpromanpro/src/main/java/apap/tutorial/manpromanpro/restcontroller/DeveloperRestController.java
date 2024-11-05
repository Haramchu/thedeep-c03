package apap.tutorial.manpromanpro.restcontroller;

import apap.tutorial.manpromanpro.restdto.response.BaseResponseDTO;
import apap.tutorial.manpromanpro.restdto.response.DeveloperOptionResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apap.tutorial.manpromanpro.restservice.DeveloperRestService;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/developer")
public class DeveloperRestController {

    @Autowired
    DeveloperRestService developerRestService;

    @GetMapping("/viewall")
    public ResponseEntity<?> listDeveloper() {
        var baseResponseDTO = new BaseResponseDTO<List<DeveloperOptionResponseDTO>>();
        List<DeveloperOptionResponseDTO> listDeveloper = developerRestService.getAllDevelopers();

        baseResponseDTO.setStatus(HttpStatus.OK.value());
        baseResponseDTO.setData(listDeveloper);
        baseResponseDTO.setMessage(String.format("List developer berhasil ditemukan"));
        baseResponseDTO.setTimestamp(new Date());

        return new ResponseEntity<>(baseResponseDTO, HttpStatus.OK);
    }
}
