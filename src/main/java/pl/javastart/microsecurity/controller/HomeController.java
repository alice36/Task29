package pl.javastart.microsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.javastart.microsecurity.model.BlogPost;
import pl.javastart.microsecurity.repository.BlogPostRepository;

import java.util.List;

@Controller
public class HomeController {

    private BlogPostRepository blogPostRepository;

    public HomeController(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<BlogPost> posts = blogPostRepository.findAll();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(){
        return "redirect:/";
    }
}
