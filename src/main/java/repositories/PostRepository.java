package repositories;

import com.codeup.springblog.Controllers.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findPostsById(Long id);
}
