package bootcamp.it.exercise.forum.controllers;

import bootcamp.it.exercise.forum.dataBaseObjects.IPostDAO;
import bootcamp.it.exercise.forum.session.SessionObject;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController {
    @Autowired
    IPostDAO postDAO;
    @Resource
    SessionObject sessionObject;


    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String news(Model model) {
        model.addAttribute("postList",postDAO.getPosts());
        model.addAttribute("sessionObject",this.sessionObject);
       // model.addAttribute("sessionObject.isModerator()",sessionObject.isModerator());
        return "posts";

    }

}
