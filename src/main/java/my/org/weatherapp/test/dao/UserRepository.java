package my.org.weatherapp.test.dao;

import my.org.weatherapp.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);

}
