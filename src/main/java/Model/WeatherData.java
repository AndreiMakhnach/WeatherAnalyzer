package Model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class WeatherData {
    @Id
    @JsonTypeId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Double temp_c;
    private Double wind_mph;
    private Double pressure_mb;
    private Double humidity;
    private String text;
    private String country;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getTemp_c() {
        return temp_c;
    }

    public Double getWind_mph() {
        return wind_mph;
    }

    public Double getPressure_mb() {
        return pressure_mb;
    }

    public Double getHumidity() {
        return humidity;
    }

    public String getText() {
        return text;
    }

    public String getCountry() {
        return country;
    }
}