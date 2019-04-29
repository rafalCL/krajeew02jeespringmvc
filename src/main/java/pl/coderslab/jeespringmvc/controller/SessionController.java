package pl.coderslab.jeespringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/session")
public class SessionController {
    @GetMapping("/getStart")
    @ResponseBody
    public String loginStart(HttpSession session){
        final LocalDateTime loginStart =
                (LocalDateTime)session.getAttribute("loginStart");

        if (loginStart==null){
            session.setAttribute("loginStart", LocalDateTime.now());
            return "dodano do sesji";
        }

        return loginStart.toString();
    }
}
