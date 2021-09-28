package homework_7;

import homework_7.controller.WeatherController;
import homework_7.model.YandexWeather;
import homework_7.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        WeatherController controller = new WeatherController(new YandexWeather());
        ConsoleView view = new ConsoleView(controller);

        view.run();
    }
}
