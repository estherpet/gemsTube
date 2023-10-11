package africa.semicolon.gemstube.data.repository;

import africa.semicolon.gemstube.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
