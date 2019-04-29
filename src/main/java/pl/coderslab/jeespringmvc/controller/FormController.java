package pl.coderslab.jeespringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {
    @GetMapping(path = "/form")
    public String form(){
        return "myForm";
    }

    @PostMapping(path = "/form")
    @ResponseBody
    public String formPost(@RequestParam String valueFromForm) {
        return "Wartość z formularza: " + valueFromForm;
    }

    @GetMapping(path = "/user/register")
    public String userForm(){
        return "user/registerForm";
    }
}
