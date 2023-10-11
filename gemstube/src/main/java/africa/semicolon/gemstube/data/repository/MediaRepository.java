package africa.semicolon.gemstube.data.repository;

import africa.semicolon.gemstube.data.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media,Long> {
}
