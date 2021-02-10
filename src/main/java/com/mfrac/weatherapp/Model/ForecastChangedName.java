package com.mfrac.weatherapp.Model;

import org.springframework.stereotype.Component;

@Component
public class ForecastChangedName {

    String description;
    String temperature;
    String pressure;
    String humidity;
    String windSpeed;

    public ForecastChangedName() {
        this.description = "descriptionDUPA";
        this.temperature = "temperatureDUPA";
        this.pressure = "pressure";
        this.humidity = "humidity";
        this.windSpeed = "windSpeed";
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


}
