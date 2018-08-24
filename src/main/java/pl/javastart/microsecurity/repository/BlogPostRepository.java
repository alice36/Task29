package pl.javastart.microsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.microsecurity.model.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
