package pl.coderslab.spring.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring.domain.model.User;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(Long id);


}
