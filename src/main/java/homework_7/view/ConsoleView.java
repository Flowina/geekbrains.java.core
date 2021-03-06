package homework_7.view;

import homework_7.controller.WeatherController;
import homework_7.model.WeatherResponse;
import homework_8.DataBaseRepository;
import homework_8.entities.Weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsoleView {
    private final String CITY = "Санкт-Петербург";
    DataBaseRepository repository = new DataBaseRepository();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private WeatherController controller;

    public ConsoleView(WeatherController controller) {
        this.controller = controller;
    }

    public void run() {
        String action = "";
        String actionLevel1 = "";
        try {
            do {
                System.out.println("1 - читать из базы данных");
                System.out.println("2 - api");
                System.out.println("0 - Exit");
                System.out.println("===========================================");
                System.out.println("Сделайте выбор");
                System.out.println("===========================================");
                actionLevel1 = br.readLine();
                System.out.println("\n");

                switch (actionLevel1) {
                    case "0":
                        System.out.println("BYE!");
                        System.exit(0);
                        break;
                    case "1":
                        List<Weather> forecasts = repository.getSavedToDBWeather();
                        if (forecasts.size() == 0) {
                            System.out.println("Нет данных");
                        } else {
                            for (Weather forecast:
                                    forecasts) {
                                System.out.println(String.format("id=%s, city=%s, date=%s, weather=%s, temperature=%s%n",
                                        forecast.getId().get(), forecast.getCity(), forecast.getLocalDate(), forecast.getWeatherText(),
                                        forecast.getTemperature()));
                            }
                        }
                        break;
                    case "2":
                        do {
                            System.out.println("1, 3, 5 дней");
                            System.out.println("0. Exit");
                            System.out.println("===========================================");
                            System.out.println("Введите количество дней");
                            System.out.println("===========================================");
                            action = br.readLine();
                            System.out.println("\n");

                            switch (action) {
                                case "1":
                                case "3":
                                case "5":
                                    System.out.print("Загрузка...");
                                    WeatherResponse wr = controller.get(Integer.parseInt(action));
                                    System.out.print("\b\b\b\b\b\b\b\b\b\b\b");
                                    System.out.println(wetherResponseToString(wr));

                                    saveToDB(wr);
                                    break;

                                case "0":
                                    System.out.println("BYE!");
                                    System.exit(0);
                                    break;

                                default:
                                    System.out.println("Invalid Action! Please enter again");
                                    break;
                            }
                        } while (!action.equals("0"));
                        break;
                }
            }
            while (!action.equals("0") || !actionLevel1.equals("0"));

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToDB(WeatherResponse wr) {
        List<Weather> list = new ArrayList<>();
        for (WeatherResponse.Forecast f :
                wr.forecasts) {
            if (f.hours.length == 0) {
                continue;
            }
            WeatherResponse.Hour h = f.hours[f.hours.length / 2];
            Weather weatherItem = new Weather(
                    CITY,
                    f.date,
                    precTypeToString(h.prec_type),
                    (double) h.temp
            );
            list.add(weatherItem);
        }
        try {
            repository.saveWeatherToDataBase(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String precTypeToString(int prec_type) {
        switch (prec_type) {
            case 0:
                return "без осадков";
            case 1:
                return "дождь";
            case 2:
                return "дождь со снегом";
            case 3:
                return "снег";
            case 4:
                return "град";
            default:
                return "???";
        }
    }

    public String wetherResponseToString(WeatherResponse wr) {
        StringBuilder sb = new StringBuilder();
        for (WeatherResponse.Forecast f :
                wr.forecasts) {
            if (f.hours.length == 0) {
                continue;
            }
            WeatherResponse.Hour h = f.hours[f.hours.length / 2];
            sb.append(String.format("В городе %s на дату %s погода ожидается %s, температура  %s%n",
                    "Санкт-Петербург", f.date, precTypeToString(h.prec_type), h.temp));
        }
        return sb.toString();
    }
}
