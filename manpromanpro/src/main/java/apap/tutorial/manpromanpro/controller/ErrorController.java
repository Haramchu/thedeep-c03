package apap.tutorial.manpromanpro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ErrorController {
    @GetMapping("/response-error-authorization")
    public String responseErrorAuthorization() {
        return "response-error-authorization";
    }
}
