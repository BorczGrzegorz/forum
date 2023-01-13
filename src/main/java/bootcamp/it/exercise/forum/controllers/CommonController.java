package bootcamp.it.exercise.forum.controllers;


import bootcamp.it.exercise.forum.interfaces.IAuthenticatorService;
import bootcamp.it.exercise.forum.interfaces.IUserDao;
import bootcamp.it.exercise.forum.model.User;
import bootcamp.it.exercise.forum.session.SessionObject;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {
    @Resource
    SessionObject sessionObject;
    @Autowired
    IUserDao userDao;
    @Autowired
    IAuthenticatorService authenticatorService;


    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        String welcome = "Witamy na stronie głównej";
        String succesfullyLogged = "Zarejestrowano pomyślnie";
        model.addAttribute("welcome", welcome);
        if (sessionObject.getUser() != null) {
            model.addAttribute("successfullyLogged", succesfullyLogged);
        }
        return "main";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String medota(@ModelAttribute User user, @RequestParam String password2) {
        if (userDao.findUserByLogin(user.getLogin()).isPresent()) {
            return "redirect:/register";
        }
        userDao.saveUser(user);
        sessionObject.setUser(user);
        return "redirect:/main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password) {
        if (!this.sessionObject.isLogged()) {
            sessionObject.setUser();
        }
          //

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "redirect:/main";  //skumać czy to dobrze,bo chyba nie
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        String informations = "Ten projekt powstał w celach dydaktycznych przez\nMichała Kruczałę :)";
        model.addAttribute("info", informations);
        return "contact";
    }

    @RequestMapping(path = "/news", method = RequestMethod.GET)
    public String news(Model model) {
        String news = "Jakieś newsy";
        model.addAttribute("newsy", news);
        return "news";
        ////zrobić szablon news:)

    }


}
