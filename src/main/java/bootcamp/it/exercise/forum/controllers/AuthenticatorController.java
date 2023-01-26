package bootcamp.it.exercise.forum.controllers;

import bootcamp.it.exercise.forum.exceptions.UserLoginExistException;
import bootcamp.it.exercise.forum.authenticator.IAuthenticatorService;
import bootcamp.it.exercise.forum.dataBaseObjects.IUserDao;
import bootcamp.it.exercise.forum.model.User;
import bootcamp.it.exercise.forum.exceptions.UserValidationException;
import bootcamp.it.exercise.forum.services.UserValidationService;
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
public class AuthenticatorController {
    @Autowired
    IUserDao userDao;
    @Resource //resource nie będzie wstrzykiwane jako komponent,tylk ojako zasób, a zasób może się zmianiać,i będzie się wstrzykiwać co żądanie http
    SessionObject sessionObject;
    @Autowired
    UserValidationService userValidationService;
    @Autowired
    IAuthenticatorService authenticatorService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @RequestParam String login, @RequestParam String password) {
        model.addAttribute("sessionObject", this.sessionObject);
        try {
            this.userValidationService.validateUserTryingToLogIn(login, password);
        } catch (UserValidationException e) {
            e.printStackTrace();
            System.out.println("nie weszłeś");
            return "redirect:/login";
        }
        this.authenticatorService.authenticate(login, password);
        if (!this.sessionObject.isLogged()) {

            return "redirect:/login";

        }
        return "redirect:/posts";

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("sessionObject", this.sessionObject);
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        sessionObject.setUser(null);
        return "redirect:/login";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("sessionObject", this.sessionObject);
        model.addAttribute("thatLoginExists", userDao.getThatLoginExists());
        model.addAttribute("user", new User());
        this.userDao.setThatLoginExists("");
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute User user, @RequestParam String password2) {
        try {
            this.userValidationService.validateRegisterUser(user, password2);
            if (userDao.findUserByLogin(user.getLogin()).isPresent()) {
                this.userDao.setThatLoginExists("***   Spróbuj ponownie z innym loginem.  ***");
                return "redirect:/register";
            }

            userDao.saveUser(user);
            sessionObject.setUser(user);
        } catch (UserLoginExistException a) {
            a.getMessage();
            return "redirect:/register";
        } catch (UserValidationException e) {
            e.getMessage();
            return "redirect:/register";
        }
        return "redirect:/posts";
    }
}
