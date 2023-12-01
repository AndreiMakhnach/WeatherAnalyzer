package Controller;

import Model.WeatherData;
import Service.WeatherService;
import org.json.simple.JSONObject;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/weather")
public class WeatherController{
    @Autowired
    private WeatherService weatherService;


    @GetMapping("/complete")
    public Object[] getWeatherComplete() {
        return weatherService.findWeatherComplete();
    }

    @GetMapping
    public WeatherData[] getWeather() {
        return weatherService.findWeather();
    }

    @GetMapping("/current")
    public ResponseEntity<WeatherData> getCurrentWeather(@RequestParam String city) throws IOException, InterruptedException {
        WeatherData currentWeather = weatherService.getCurrentWeather(city);
        return ResponseEntity.ok(currentWeather);
    }

    @GetMapping("/average")
    public ResponseEntity<Double> getAverageTemperature(@RequestParam String city,
                                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        Double averageTemperature = weatherService.getAverageTemperature(city, from, to);
        return ResponseEntity.ok(averageTemperature);
    }


//        Weather information on the required city from the selected service.
//        Recording and uploading from a database
//    @GetMapping("/city")
//    public JSONObject getWeatherFromCityName(@PathVariable final String city,
//                                             @PathVariable final String service) throws IOException, ParseException {
//        JSONParser parser = new JSONParser(city);
//
//        if ("openWeather".equals(service)){
//            saveWeatherToDB(city);
//            String weather = weatherRepository.findFirstByOrderByCreatedAtDesc().getOpenWeatherData();
//            return (JSONObject) parser.parse(weather);
//        }else if ("stackWeather".equals(service)){
//            saveWeatherToDB(city);
//            String weather = weatherDataRepository.findFirstByOrderByCreatedAtDesc().getWeatherStackData();
//            return (JSONObject) parser.parse(weather);
//        }else{
//            return (JSONObject) parser.parse(getWeatherJson(city, service));
//        }
//
//    }
//
//    private void saveWeatherToDB(String city) throws IOException {
//        WeatherData weather = new WeatherData(city, getOpenWeatherJson(city), getStackWeatherJson(city));
//        weatherRepository.save(weather);
//    }
}
