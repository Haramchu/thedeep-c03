package apap.tutorial.manpromanpro.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import apap.tutorial.manpromanpro.restservice.RomanRestService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/roman")
public class RomanRestController {

    @Autowired
    private RomanRestService romanRestService;
    
    @GetMapping("/convert-roman/{roman}")
    public ResponseEntity<?> convertRomanToInteger(@PathVariable String roman) {
        var response = romanRestService.convertRomanToInteger(roman);
        if (response.containsKey("error")) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
    
    @GetMapping("/convert-integer/{integer}")
    public ResponseEntity<?> convertIntegerToRoman(@PathVariable String integer) {
        var response = romanRestService.convertIntegerToRoman(integer);
        if (response.containsKey("error")) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}