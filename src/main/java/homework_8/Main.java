package homework_8;

import homework_8.entities.Weather;

import java.sql.SQLException;
import java.util.List;

/*1. Добавить поддержку SQLite в проект.
2. Создать класс-репозиторий, отвечающий за взаимодействие с базой данных.
3. Организовать запись данных в базу при каждом успешном API запросе.
 Формат - String city, String localDate, String weatherText, Double temperature.
4. Организовать чтение из базы всех данных по пункту меню (требует переработки меню)
5. Учесть, что соединение всегда нужно закрывать*/
public class Main {
    public static void main(String[] args) {
        DataBaseRepository rep = new DataBaseRepository();
        try {
            //rep.saveWeatherToDataBase(new Weather("спб","2021-10-01","солнечно",1.0));

            List<Weather> forecasts = rep.getSavedToDBWeather();
            for (Weather forecast:
                 forecasts) {
                System.out.println(String.format("id=%s, city=%s, date=%s, weather=%s, temperature=%s%n",
                        forecast.getId().get(), forecast.getCity(), forecast.getLocalDate(), forecast.getWeatherText(),
                        forecast.getTemperature()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
