package my.org.weatherapp.test.controller;

import my.org.weatherapp.test.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RestController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/myRest/{city}", method = RequestMethod.GET)
    @ResponseBody
    public String getWeather(@PathVariable("city") String city){
        return weatherService.getWeatherCity(city);
    }

}
