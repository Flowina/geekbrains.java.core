package homework_8.entities;

import java.util.Optional;

public class Weather {
    private Optional<Integer> id;
    private String city;
    private String localDate;
    private String weatherText;
    private Double temperature;

    public Weather(String city, String localDate, String weatherText, Double temperature) {
        this(Optional.empty(), city, localDate, weatherText, temperature);
    }

    public Weather(Optional<Integer> id, String city, String localDate, String weatherText, Double temperature) {
        this.id = id;
        this.city = city;
        this.localDate = localDate;
        this.weatherText = weatherText;
        this.temperature = temperature;
    }

    public Optional<Integer> getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setId(Optional<Integer> id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
