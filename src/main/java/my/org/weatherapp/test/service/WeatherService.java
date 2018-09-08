package my.org.weatherapp.test.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DecimalFormat;


@Service
public class WeatherService {

    private Logger logger = LoggerFactory.getLogger(WeatherService.class);

    @Value("${my.url_weather}")
    private String URL;

    @Value("${my.appid_weather}")
    private String APIID;

    private float toCelsius(float temperatureKelvin) {
        return (float) (temperatureKelvin - 273.15);
    }

    public String readUrlCity(String city) throws IOException {
        BufferedReader reader = null;
        try {
            java.net.URL url = new URL(URL + city + APIID);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);
            return buffer.toString();

        } finally {
            if (reader != null)
                reader.close();
        }

    }

    public String getWeatherCity(String city) {
        String jsonString = null;
        try {
            jsonString = readUrlCity(city);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("We take IO exception, URL not defined, not responded or city not exists");
            return "Bad URL";
        }
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
        JsonObject jsonMain = jsonObject.get("main").getAsJsonObject();
        logger.info("About " + city + " main info: " + jsonMain.toString());
        float temperatureKelvin = jsonMain.get("temp").getAsFloat();
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(toCelsius(temperatureKelvin));
    }


}
