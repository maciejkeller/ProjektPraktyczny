package external.client;

import com.squareup.okhttp.OkHttpClient;
import lombok.*;

@Data
public class AccuWeatherAPIClient {

    private final OkHttpClient okHttpClient;

}
