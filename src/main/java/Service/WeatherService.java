package Service;

import Model.WeatherData;
import Repository.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class WeatherService {
    @Autowired
    private RestTemplate template = new RestTemplate();

    public Object[] findWeatherComplete() {
        return template.getForObject("https://rapidapi.com/weatherapi/api", Object[].class);
    }

    public WeatherData[] findWeather() {
        return template.getForObject("https://rapidapi.com/weatherapi/api", WeatherData[].class);
    }


    // Метод для сохранения данных о погоде в БД
//    public void saveWeatherData(WeatherData weatherData) {
//        weatherRepository.save(weatherData);
//    }

    // Метод для получения текущей погоды
    public WeatherData getCurrentWeather(String city) throws IOException, InterruptedException {
        // Реализация получения данных от стороннего API
        // ...


        // Предположим, что данные получены и создаем объект WeatherData
        WeatherData currentWeather = new WeatherData();
        // Устанавливаем данные
        // ...

        // Сохраняем данные в БД
//        saveWeatherData(currentWeather);

        return currentWeather;
    }

    // Метод для получения среднесуточной температуры
    public Double getAverageTemperature(String city, LocalDate from, LocalDate to) {
        LocalDateTime fromDate = from.atStartOfDay();
        LocalDateTime toDate = to.atTime(LocalTime.MAX);

        //List<WeatherData> weatherDataList = weatherDataRepository.findByCityAndTimestampBetween(city, from, to);
        // Рассчет среднесуточной температуры
        // ...

        Double calculatedAverageTemperature = null;
        return calculatedAverageTemperature;
    }
}
