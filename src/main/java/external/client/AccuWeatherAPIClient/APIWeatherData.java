package external.client.AccuWeatherAPIClient;


import lombok.Data;

@Data
public class APIWeatherData {
    private Localization localizationKey;
    private Integer temperature;
    private Integer pressure;
    private Integer humidity;
    private String windDirection;
    private Integer windVelocity;
}