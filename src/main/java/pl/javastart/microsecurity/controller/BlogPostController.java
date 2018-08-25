package pl.javastart.microsecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.microsecurity.model.BlogPost;
import pl.javastart.microsecurity.model.User;
import pl.javastart.microsecurity.repository.BlogPostRepository;
import pl.javastart.microsecurity.repository.UserRepository;

import java.security.Principal;
import java.util.Optional;

@Controller
public class BlogPostController {

    private BlogPostRepository blogPostRepository;
    private UserRepository userRepository;

    public BlogPostController(BlogPostRepository blogPostRepository, UserRepository userRepository) {
        this.blogPostRepository = blogPostRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/dodaj")
    public String addForm(Model model) {

        model.addAttribute("newPost", new BlogPost());
        return "addform";
    }

    @PostMapping("/dodaj")
    public String addBlogPost(BlogPost blogPost, Principal principal) {

        User byUsername =userRepository.findUserUsingUsername(principal.getName());
        if(byUsername.getUsername()=="") {
            blogPostRepository.save(blogPost);
            return "redirect:/";
        } else {
            ResponseEntity.notFound().build();
            return "error";
        }
    }
}
