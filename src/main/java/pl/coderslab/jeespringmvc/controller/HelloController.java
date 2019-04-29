package pl.coderslab.jeespringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalTime;

@Controller
public class HelloController {
    @GetMapping(path = "/hello",
              produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String helloWorld(){
        return "Hello world!";
    }


    @GetMapping("/helloView")
    public String helloView(Model model){
        String fontColor = "white";
        String bgColor = "black";

        final int hour = LocalTime.now().getHour();
        if(hour >= 8 && hour < 20){
            fontColor = "black";
            bgColor = "white";
        }

        model.addAttribute("fontColor", fontColor);
        model.addAttribute("bgColor", bgColor);

        return "home";
    }
}
