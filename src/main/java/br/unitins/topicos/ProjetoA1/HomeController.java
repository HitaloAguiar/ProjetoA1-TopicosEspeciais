package br.unitins.topicos.ProjetoA1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String redirecionarParaSwagger() {

        return "redirect:/swagger-ui.html";
    }
}
