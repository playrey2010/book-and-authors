package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {
        Book b = new Book();
        Author a = new Author();
        a.setFirstName("Joel");
        a.setLastName("Murach");
        model.addAttribute("authorA", a);
        return "index";
    }
}
