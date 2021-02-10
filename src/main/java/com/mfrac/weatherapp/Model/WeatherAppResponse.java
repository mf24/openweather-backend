package com.mfrac.weatherapp.Model;

import org.springframework.stereotype.Component;

@Component
public class WeatherAppResponse {

    String city;
    String description;
    String temperature;
    String pressure;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    String humidity;
    String windSpeed;

    public WeatherAppResponse() {

        this.city="city";
        this.description="desc";
        this.temperature="temps";
        this.pressure="pres";
        this.humidity="hum";
        this.windSpeed="wind";

    }



    public static final class Builder {

        String city;
        String description;
        String temperature;
        String pressure;
        String humidity;
        String windSpeed;


        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withTemperature(String temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder withPressure(String pressure) {
            this.pressure = pressure;
            return this;
        }

        public Builder withHumidity(String humidity) {
            this.humidity = humidity;
            return this;
        }

        public Builder withWindSpeed(String windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public WeatherAppResponse build() {
            WeatherAppResponse weatherAppResponse = new WeatherAppResponse();

            weatherAppResponse.city = this.city;
            weatherAppResponse.description = this.description;
            weatherAppResponse.temperature = this.temperature;
            weatherAppResponse.pressure = this.pressure;
            weatherAppResponse.humidity = this.humidity;
            weatherAppResponse.windSpeed = this.windSpeed;

            return weatherAppResponse;
        }
    }
}
