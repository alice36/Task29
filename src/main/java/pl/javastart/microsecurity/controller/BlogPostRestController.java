package pl.javastart.microsecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.javastart.microsecurity.model.BlogPost;
import pl.javastart.microsecurity.repository.BlogPostRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class BlogPostRestController {
    private BlogPostRepository blogPostRepository;

    public BlogPostRestController(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @GetMapping
    public List<BlogPost> getAllBlogPosts(@RequestParam(required = false) String title) {
        if (title==null) {
            return blogPostRepository.findAll();
        } else {
            return blogPostRepository.findBlogPostByTitlePart(title);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getBlogPost(@PathVariable("id") Long id){

        Optional<BlogPost> byId = blogPostRepository.findById(id);
        if(byId.isPresent()) {
            return ResponseEntity.ok(byId.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
