package homework_7.model;

// https://yandex.ru/dev/weather/doc/dg/concepts/forecast-test.html#resp-format__forecasts
public class WeatherResponse {
    public Forecast[] forecasts;

    public class Forecast {
        public String date;
        public Hour[] hours;
    }

    public class Hour {
        public String hour;
        public int temp;
        public int prec_type = -1;

    }
}
