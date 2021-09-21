package homework_6;

public class Main {
    public static void main(String[] args) {
        try {
            String resp = WeatherForecast.get(5);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
