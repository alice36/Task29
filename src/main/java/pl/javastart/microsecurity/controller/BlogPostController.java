package pl.javastart.microsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.microsecurity.model.BlogPost;
import pl.javastart.microsecurity.repository.BlogPostRepository;

@Controller
public class BlogPostController {

    private BlogPostRepository blogPostRepository;

    public BlogPostController(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @GetMapping("/dodaj")
    public String addForm() {
        return "addform";
    }

    @PostMapping("/dodaj")
    public String addBlogPost(@RequestParam String title, @RequestParam String content) {
        blogPostRepository.save(new BlogPost(title, content));
        return "redirect:/";
    }

}
