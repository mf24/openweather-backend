package com.mfrac.weatherapp.Service;

import com.mfrac.weatherapp.Model.ForecastResponse;
import com.mfrac.weatherapp.Model.WeatherAppResponse;
import org.springframework.stereotype.Service;

@Service
public class WeatherAppService {
    public WeatherAppResponse mapToBasicData(ForecastResponse response) {

        return new WeatherAppResponse.Builder()
                .withCity(response.getName())
                .withDescription(response.getWeather().get(0).getDescription())
                .withTemperature(response.getMain().getTemp().toString())
                .withWindSpeed(response.getWind().getSpeed().toString())
                .withHumidity(response.getMain().getHumidity().toString())
                .withPressure(response.getMain().getPressure().toString())
                .build();
    }
}
