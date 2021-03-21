package external.client.AccuWeatherAPIClient;

import com.squareup.okhttp.OkHttpClient;
import lombok.*;

@Data
@AllArgsConstructor
public class AccuWeatherAPIClient {

    private final OkHttpClient okHttpClient;

}