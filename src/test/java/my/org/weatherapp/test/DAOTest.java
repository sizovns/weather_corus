package my.org.weatherapp.test;

import my.org.weatherapp.test.model.History;
import my.org.weatherapp.test.model.User;
import my.org.weatherapp.test.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DAOTest {

    @Autowired
    private UserService userService;

    @Test
    public void checkUser() {
        User firsIntitalisation = userService.findUser("test");
        userService.delete(firsIntitalisation);
        User user = new User();
        user.setLogin("test");
        user.setPassword("test");
        History history = new History();
        history.setHistory("My test history");
        List<History> histories = new ArrayList<>();
        histories.add(history);
        user.setWeathers(histories);
        userService.save(user);
        User userDao = userService.findUser("test");

        //Test users login
        Assert.assertEquals(user.login, userDao.login);
        //Test users password
        Assert.assertEquals(user.getPassword(), userDao.getPassword());
        //Test users history
        Assert.assertEquals(user.getWeathers().get(0).getHistory(), userDao.getWeathers().get(0).getHistory());
    }
}
