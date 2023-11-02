package africa.semicolon.gemstube.data.repository;

import africa.semicolon.gemstube.data.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
