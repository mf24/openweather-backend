package com.mfrac.weatherapp.Controller;

import com.mfrac.weatherapp.Config.OpenWeatherConfiguration;
import com.mfrac.weatherapp.Mapper.WeatherAppMapper;
import com.mfrac.weatherapp.Model.ForecastResponse;
import com.mfrac.weatherapp.Model.WeatherAppResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OpenWeatherControllerTest {

    @Mock
    RestTemplate restTemplate;
    @Mock
    HttpEntity<String> httpEntity;
    @Mock
    OpenWeatherConfiguration openWeatherConfiguration;

    @InjectMocks
    OpenWeatherController openWeatherController;

    @Test
    public void shouldReturnHttpStatusOk() {
        //given
        when(openWeatherConfiguration.getToken()).thenReturn("token");
        when(openWeatherConfiguration.getUrl()).thenReturn("url");
        when(restTemplate.exchange("url/weather?id={id}&appid={appid}&lang={lang}&mode={mode}", HttpMethod.GET, httpEntity, ForecastResponse.class, "756135", "token", "en", "json"))
                .thenReturn(new ResponseEntity<>(HttpStatus.OK));
        //when
        ResponseEntity<WeatherAppResponse> byCityId = openWeatherController.getByCityId("756135", "en", "json");
        //then
        assertThat(byCityId.getStatusCode().value()).isEqualTo(200);
    }
}
