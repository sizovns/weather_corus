package my.org.weatherapp.test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import my.org.weatherapp.test.service.WeatherService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherTest {

    @Autowired
    private WeatherService weatherService;

    @Test
    public void getWeatherCityTest(){
        Assert.assertEquals(weatherService.getWeatherCity("London3"), "Bad URL");

        try {
            Assert.assertEquals(weatherService.readUrlCity("Moscow2"), null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWeatherinLondon(){
        String jsonString = "";
        try {
            jsonString = weatherService.readUrlCity("London");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
        Assert.assertEquals(weatherService.getWeatherCity("London"), weatherService.getWeatherCity(jsonObject.get("name").getAsString()));
    }


}
