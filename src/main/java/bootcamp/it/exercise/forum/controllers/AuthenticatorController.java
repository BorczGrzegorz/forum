package bootcamp.it.exercise.forum.controllers;

import bootcamp.it.exercise.forum.exceptions.UserLoginExistException;
import bootcamp.it.exercise.forum.interfaces.IUserDao;
import bootcamp.it.exercise.forum.model.User;
import bootcamp.it.exercise.forum.services.UserValidationException;
import bootcamp.it.exercise.forum.services.UserValidationService;
import bootcamp.it.exercise.forum.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticatorController {
    @Autowired
    IUserDao userDao;
    @Autowired
    SessionObject sessionObject;
    @Autowired
    UserValidationService userValidationService;





    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password) {
        try {
            this.userValidationService.validateUser(login, password);
        } catch (UserValidationException e) {
            e.printStackTrace();
        }
//        if (!this.sessionObject.isLogged()) {
//              sessionObject.setUser();
//        }
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("sessionObject", this.sessionObject);
        return "login";  //skumać czy to dobrze,bo chyba nie
    }






    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String medota(@ModelAttribute User user, @RequestParam String password2) throws UserLoginExistException {

        if (userDao.findUserByLogin(user.getLogin()).isPresent()) {
            return "redirect:/register";
        }
        userDao.saveUser(user);
        sessionObject.setUser(user);
        return "redirect:/main";
    }
}
