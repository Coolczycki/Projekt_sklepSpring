package sklep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class RootController {

    @GetMapping("")
    public String index(){
        return "index";
    }

    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello World";
    };

    @GetMapping("godzina")
    public String ktoraGodzina(Model model) {
        LocalDateTime teraz = LocalDateTime.now();
        model.addAttribute("dt", teraz);
        return "pokaz_czas";
    }
}
