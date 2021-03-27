package external.client.AccuWeatherAPIClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import lombok.*;

import java.io.IOException;

@Data
@AllArgsConstructor
public class AccuWeatherAPIClient {

    private final OkHttpClient okHttpClient;

    public Localization generateLocalizationKey(String lat, String lon) {

        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/locations/v1/cities/geoposition/search?apikey=AWxzPnZxIY4G2Rw4jC32NLLmWqxmFJ16&" +
                        "q=" + lat + "%2C" + lon +
                        "&language=pl-pl")
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                String json = response.body().string();
                Gson gson = getGson();
                return gson.fromJson(json, Localization.class);
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public APIWeatherData generateWeatherData(String locationKey) {

        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/1day/" +
                        locationKey +
                        "?apikey=AWxzPnZxIY4G2Rw4jC32NLLmWqxmFJ16&language=pl-pl&details=true&metric=true")
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                String json = response.body().string();
                Gson gson = getGson();
                return gson.fromJson(json, APIWeatherData.class);
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Gson getGson() {
        return new GsonBuilder()
                .create();
    }
}