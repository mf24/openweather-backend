package com.mfrac.weatherapp.Mapper;

import com.mfrac.weatherapp.Model.Error;
import com.mfrac.weatherapp.Model.ForecastResponse;
import com.mfrac.weatherapp.Model.WeatherAppResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherAppMapper {
    public WeatherAppResponse mapBasicForecastData(ResponseEntity<ForecastResponse> response) {

        if (Optional.ofNullable(response).map(HttpEntity::getBody).isPresent()) {
            return new WeatherAppResponse.Builder()
                    .withCity(response.getBody().getName())
                    .withDescription(response.getBody().getWeather().get(0).getDescription())
                    .withTemperature(response.getBody().getMain().getTemp().toString())
                    .withWindSpeed(response.getBody().getWind().getSpeed().toString())
                    .withHumidity(response.getBody().getMain().getHumidity().toString())
                    .withPressure(response.getBody().getMain().getPressure().toString())
                    .build();
        } else {
            return new WeatherAppResponse.Builder()
                    .withWithError(new Error("No body in response", "invalid data"))
                    .build();
        }
    }
}
