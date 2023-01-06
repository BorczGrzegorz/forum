package bootcamp.it.exercise.forum.controllers;


import bootcamp.it.exercise.forum.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommonController {

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String metoda(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String medota(@ModelAttribute User user, @RequestParam String password2){
        if(user.getLogin().equals(password2)){
            System.out.println("hasła są poprawne");
        }
        System.out.println(user.getLogin());
        return "main";
    }
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        String welcome = "Witamy na stronie głównej";
        List<String> list = new ArrayList<>();
        list.add("Stare Miasto");
        list.add("Krowodrza Górka");
        list.add("Podgórze");
        list.add("Prądnik Biały");
        list.add("Nowa Huta");
        model.addAttribute("welcome", welcome);
        model.addAttribute("districts", list);
        return "main";
    }
}
