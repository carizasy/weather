package com.weather.service;

import com.weather.model.Weather;

public interface WeatherService {

	Weather getWeather(String location);
}
