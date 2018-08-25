package pl.javastart.microsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.javastart.microsecurity.model.BlogPost;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    @Query("SELECT b from BlogPost b " +
            "where lower(b.title) like :letter%")
    List<BlogPost> findBlogPostByTitlePart(@Param("letter") String letter);
}
