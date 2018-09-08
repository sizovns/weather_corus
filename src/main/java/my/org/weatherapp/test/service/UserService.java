package my.org.weatherapp.test.service;

import my.org.weatherapp.test.dao.UserRepository;
import my.org.weatherapp.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUser(String login){
        return userRepository.findByLogin(login);
    }

    public void save (User user){
        userRepository.saveAndFlush(user);
    }

    public void delete(User user){
        userRepository.delete(user);
    }
}
