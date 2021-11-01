package homework_7.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

public class YandexWeather implements WeatherForecast {
    private static final String apiKey = "d9a3992b-ba5e-4ebb-887c-bd07736e393c";

    @Override
    public WeatherResponse get(int days) throws Exception {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("api.weather.yandex.ru")
                .addPathSegment("v2")
                .addPathSegment("forecast")
                .addQueryParameter("lat", "59.95240058553464")
                .addQueryParameter("lon", "30.316184796874996")
                .addQueryParameter("limit", String.valueOf(days))
                .addQueryParameter("lang", "ru_RU")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("X-Yandex-API-Key", apiKey)
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();
        if (response.code() == 200) {
            String body = response.body().string();
            return parseResponse(body);
        } else {
            throw new Exception("ошибка получения данных.код ответа = " + response.code());
        }
    }

    public WeatherResponse parseResponse(String responseBody) {
        Type type = (new TypeToken<WeatherResponse>() {}).getType();
        WeatherResponse resp = new Gson()
                .fromJson(responseBody.trim(), type);
        return resp;
    }
}
