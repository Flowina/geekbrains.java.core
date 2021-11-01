package homework_7.controller;

import homework_7.model.WeatherForecast;
import homework_7.model.WeatherResponse;

public class WeatherController {
    private WeatherForecast weatherForecast;

    public WeatherController(WeatherForecast weatherForecast) {
        this.weatherForecast = weatherForecast;
    }

    public WeatherResponse get(int days) throws Exception {
        return weatherForecast.get(days);
    }
}
