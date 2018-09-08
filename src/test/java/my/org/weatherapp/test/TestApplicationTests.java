package my.org.weatherapp.test;

import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import my.org.weatherapp.test.controller.LoginController;
import my.org.weatherapp.test.controller.RestController;
import my.org.weatherapp.test.controller.TestController;
import my.org.weatherapp.test.model.History;
import my.org.weatherapp.test.model.User;
import my.org.weatherapp.test.service.UserService;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {


    @Autowired
    private LoginController loginController;
    @Autowired
    private TestController testController;
    @Autowired
    private RestController restController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(loginController).isNotNull();
        assertThat(testController).isNotNull();
        assertThat(restController).isNotNull();

    }

    // Тест для проверки работы с БД, создание тестового пользователя, проверка на соответсвии пользователя в БД.
    // Запись тестовой истории и так же проверка на сущетвование в БД



}
