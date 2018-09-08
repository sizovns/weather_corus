package my.org.weatherapp.test.controller;

import groovy.util.logging.Slf4j;
import my.org.weatherapp.test.model.History;
import my.org.weatherapp.test.model.User;
import my.org.weatherapp.test.model.Weather;
import my.org.weatherapp.test.service.UserService;
import my.org.weatherapp.test.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;


@Controller
@Slf4j
public class TestController {

    @Autowired
    UserService userService;

    private Logger logger = LoggerFactory.getLogger(TestController.class);


    @Autowired
    private WeatherService service;

    @RequestMapping(value = "/weather", method = RequestMethod.GET)
    public String greetingForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        logger.info("Yor are logging in by user: " + currentPrincipalName);
        List<History> historyList = userService.findUser(currentPrincipalName).getWeathers();
        if(historyList.isEmpty()){
            History history = new History();
            history.setHistory("You didn't have history");
            logger.info("You didn't have history");
            historyList.add(history);
        }
        model.addAttribute("history", historyList);
        model.addAttribute("weather", new Weather());
        return "weather";
    }

    @RequestMapping(value = "/weather", method = RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Weather weather, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userService.findUser(currentPrincipalName);
        List<History> histories = user.getWeathers();
        logger.info("Searching temperature in city: " + weather.getCity());
        weather.setTemperature(service.getWeatherCity(weather.getCity()));
        if (!weather.getTemperature().equalsIgnoreCase("bad url")) {
            History history = new History();
            history.setHistory(weather.toString());
            histories.add(history);
            userService.save(user);
        }
        logger.info("In city: " + weather.getCity() + " temperature is: " + weather.getTemperature());
        model.addAttribute("weather", weather);
        return "result";
    }


}
