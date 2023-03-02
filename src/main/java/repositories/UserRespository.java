package repositories;

import com.codeup.springblog.Controllers.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Long> {
    User findUserById(long id);
}
