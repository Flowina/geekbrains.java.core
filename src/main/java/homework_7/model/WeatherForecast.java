package homework_7.model;

public interface WeatherForecast {
    WeatherResponse get(int days) throws Exception;
}
