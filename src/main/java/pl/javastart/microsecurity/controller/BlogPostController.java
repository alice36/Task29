package pl.javastart.microsecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.javastart.microsecurity.model.BlogPost;
import pl.javastart.microsecurity.model.User;
import pl.javastart.microsecurity.model.UserRole;
import pl.javastart.microsecurity.repository.BlogPostRepository;
import pl.javastart.microsecurity.repository.UserRepository;
import pl.javastart.microsecurity.repository.UserRoleRepository;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogPostController {

    private BlogPostRepository blogPostRepository;
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    public BlogPostController(BlogPostRepository blogPostRepository, UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.blogPostRepository = blogPostRepository;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @GetMapping("/dodaj")
    public String addForm(Model model) {

        model.addAttribute("newPost", new BlogPost());
        return "addform";
    }

    @GetMapping("/administracja")
    public String admin(Model model, Principal principal) {
        List<BlogPost> blogPostList = blogPostRepository.findAll();
        UserRole userRole = userRoleRepository.findUserRoleUsingUsername(principal.getName());
        if (userRole.getRole().equals("ROLE_ADMIN")){
            model.addAttribute("blogPostList", blogPostList);
            return "admin";
        }
        else {
            return "errorHtml";
        }
    }

    @PostMapping("/dodaj")
    public String addBlogPost(BlogPost blogPost, Principal principal) {

        User byUsername =userRepository.findUserUsingUsername(principal.getName());
        if(byUsername.getUsername()!="") {
            blogPostRepository.save(blogPost);
            return "redirect:/";
        } else {
            return "errorHtml";
        }
    }

}
