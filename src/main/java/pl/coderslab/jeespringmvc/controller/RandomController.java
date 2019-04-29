package pl.coderslab.jeespringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@RequestMapping("/random")
public class RandomController {
    @GetMapping(path = "/{max}",
            produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String randomMax(@PathVariable int max) {
        Random rand = new Random();
        final int result = rand.nextInt(max) + 1;

        return "Użytkownik podał wartość " + max +
                ". Wylosowano liczbę: " + result;
    }


    @GetMapping(path = "/{min}/{max}",
            produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String randomMinMax(@PathVariable int min,
                               @PathVariable int max) {
        Random rand = new Random();
        final int result = min + rand.nextInt(max - min + 1);

        return "Użytkownik podał wartości: " + min + " i "+ max +
                ". Wylosowano liczbę: " + result;
    }
}
