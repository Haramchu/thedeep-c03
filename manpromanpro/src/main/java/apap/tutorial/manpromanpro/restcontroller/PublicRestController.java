package apap.tutorial.manpromanpro.restcontroller;

import apap.tutorial.manpromanpro.restdto.request.UpdateProyekRequestRestDTO;
import apap.tutorial.manpromanpro.restdto.response.BaseResponseDTO;
import apap.tutorial.manpromanpro.restdto.request.AddProyekRequestRestDTO;
import apap.tutorial.manpromanpro.restdto.response.ProyekResponseDTO;
import apap.tutorial.manpromanpro.restservice.ProyekRestService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PublicRestController {
    @GetMapping("/random")
    public ResponseEntity<?> random() {
        Random random = new Random();
        var theBool = random.nextBoolean();
        if (theBool) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    
}