package com.weather.service.impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.openweathermap.model.WeatherForecast;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.model.Weather;
import com.weather.service.WeatherService;
import com.weather.util.ConversionUtil;

@Service
public class OpenWeatherServiceImpl implements WeatherService{
	
	private final String celsius="\u00b0"+"C";
	private final String kph="km/h";


	RestTemplate restTemplate = new RestTemplate();

	@Value("#{'${api.link}'}")
	private String apiLink;

	@Value("#{'${api.key}'}")
	private String apiKey;

	@Override
	public Weather getWeather(String location) {
		WeatherForecast forecast = restTemplate.getForObject(apiLink+location+"&APPID="+apiKey+"&units=metric", WeatherForecast.class);

		ResponseEntity<WeatherForecast> responseEntity= restTemplate.getForEntity(apiLink+location+"&APPID="+apiKey, WeatherForecast.class);
		
		System.out.println(responseEntity.getStatusCode());
		
		if(forecast!=null){
			
			Date today;
			String result;
			SimpleDateFormat formatter;

			formatter = new SimpleDateFormat("EEEE hh:mm aa");
			today = new Date();
			result = formatter.format(today);
			System.out.println("Result: " + result);

			DecimalFormat df = new DecimalFormat("#.##");
			
			Weather weather = new Weather();
			weather.setCity(forecast.getName());
			weather.setTime(result);
			weather.setTemperature(String.valueOf(forecast.getMain().getTemp())+celsius);
			weather.setWeatherDesc(forecast.getWeather().get(0).getDescription());
			weather.setWind(String.valueOf(ConversionUtil.windMPStoKPH(forecast.getWind().getSpeed()))+kph);
			weather.setStatusCode(forecast.getCod());
			return weather;
		}else{
			return null;
		}
	}

	public String getApiLink() {
		return apiLink;
	}

	public void setApiLink(String apiLink) {
		this.apiLink = apiLink;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}



}

