package bootcamp.it.exercise.forum;


import bootcamp.it.exercise.forum.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @RequestMapping(value = "/parametry", method = RequestMethod.GET)
    public String metoda(Model model) {
        model.addAttribute("imie", "po prostu imie");


        return "form";
    }

    @RequestMapping(value = "/parametry2", method = RequestMethod.POST)
    public String metoda2process(User user) {
        System.out.println(user.getLogin() + " " + user.getPassword() + " " + user.getPassword2()
                + " " + user.getName() + " " + user.getSurname());
        return "cos";
    }
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model){
        String welcome ="Witamy na stronie głównej";
        List<String> districtList = new ArrayList<>();
        districtList.add("Stare Miasto");
                districtList.add("Krowodrza Górka");
                districtList.add("Podgórze");
                districtList.add("Prądnik Biały");
                districtList.add("Nowa Huta");
        model.addAttribute("welcome", welcome);
        model.addAttribute("districts",districtList);
        return "main";
    }
}
