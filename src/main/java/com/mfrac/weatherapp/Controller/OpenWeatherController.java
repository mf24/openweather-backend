package com.mfrac.weatherapp.Controller;

import com.mfrac.weatherapp.Config.OpenWeatherConfiguration;
import com.mfrac.weatherapp.Mapper.WeatherAppMapper;
import com.mfrac.weatherapp.Model.ForecastResponse;
import com.mfrac.weatherapp.Model.WeatherAppResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
@PropertySource(value = "classpath:application.yaml")
public class OpenWeatherController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpEntity<String> httpEntity;

    @Autowired
    WeatherAppMapper weatherAppMapper;

    @Autowired
    OpenWeatherConfiguration openWeatherConfiguration;

    @GetMapping("/city/{id}")
    public ResponseEntity<WeatherAppResponse> getByCityId(@PathVariable String id, @RequestParam(required = false, defaultValue = "en") String lang,
                                                          @RequestParam(required = false, defaultValue = "json") String mode) {

        ResponseEntity<ForecastResponse> response = restTemplate.exchange(openWeatherConfiguration.getUrl() + "/weather?id={id}&appid={appid}&lang={lang}&mode={mode}",
                HttpMethod.GET, httpEntity, ForecastResponse.class, id, openWeatherConfiguration.getToken(), lang, mode);

        WeatherAppResponse weatherAppResponse = weatherAppMapper.mapBasicForecastData(response);

        return new ResponseEntity<>(weatherAppResponse, HttpStatus.OK);

        //TODO: response validation and mapping

    }

    @PostMapping("/alert")
    public void getByCityId() {
        //TODO: notification maintenance
    }
}
