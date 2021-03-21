package external.client.AccuWeatherAPIClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import lombok.*;

import java.io.IOException;
import java.util.Scanner;

@Data
@AllArgsConstructor
public class AccuWeatherAPIClient {

    private final OkHttpClient okHttpClient;
    private final static Scanner SCANNER = new Scanner(System.in);

    public Localization generateLocalizationKey() {
        System.out.println("Podaj szerokość geograficzną w formacie CC.CCCCCCC \n C - cyfra");
        String lat = SCANNER.nextLine();
        System.out.println("Podaj długość geograficzną w formacie CC.CCCCCCC \n C - cyfra");
        String lon = SCANNER.nextLine();

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

    public WeatherData generateWeatherData() {
        String locationKey = generateLocalizationKey().getKey();
        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/1day/" +
                        locationKey +
                        "?apikey=AWxzPnZxIY4G2Rw4jC32NLLmWqxmFJ16&language=pl-pl&details=true&metric=true")
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()){
                String json = response.body().string();
                Gson gson = getGson();
                return  gson.fromJson(json, WeatherData.class);
            }
            return null;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private Gson getGson() {
        return new GsonBuilder()
                .create();
    }
}