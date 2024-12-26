package apap.tutorial.manpromanpro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProyekController {

    @GetMapping("/")
    private String home(Model model) {
        return "home";
    }

}