package my.org.weatherapp.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {


    @RequestMapping(value="/")
    public String gotosingIn(){
        return "redirect:/signIn";
    }

    @RequestMapping(value="/signIn")
    public String singIn(){
        return "signIn";
    }

}

