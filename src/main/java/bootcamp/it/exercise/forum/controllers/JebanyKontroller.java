package bootcamp.it.exercise.forum.controllers;

import bootcamp.it.exercise.forum.dataBaseObjects.IPostDAO;
import bootcamp.it.exercise.forum.model.Post;
import bootcamp.it.exercise.forum.session.SessionObject;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class JebanyKontroller {
    @Autowired
    IPostDAO postDAO;
    @Resource
    SessionObject sessionObject;

    @RequestMapping(path = "/edit/{postId}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable int postId) {
        Optional<Post> postById = postDAO.getPostById(postId);
        if (postById.isEmpty()) {
            return "redirect:/posts";
        }
        model.addAttribute("sessionObject", this.sessionObject);
        model.addAttribute("post", postById.get());
        return "posts";
    }

    @RequestMapping(path = "/edit/{postId}", method = RequestMethod.POST)
    public String edit(@ModelAttribute Post post,
                       @PathVariable int postId) {
        try {
            postDAO.editPost(post, postId);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("weszło do catch");
            return "redirect:/edit/post/" + postId;
        }
        return "redirect:/posts";
    }
}
