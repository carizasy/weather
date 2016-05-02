package com.weather;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import static org.mockito.Mockito.*;
import junit.framework.TestCase;

import com.weather.controller.WeatherController;
import com.weather.model.Weather;
import com.weather.service.WeatherService;
import com.weather.service.impl.OpenWeatherServiceImpl;

import junit.framework.TestCase;

public class WeatherControllerTest extends TestCase {

	@Test
	public void test() {
		//GIVEN		
		OpenWeatherServiceImpl fakeWeatherService = new OpenWeatherServiceImpl();
		fakeWeatherService.setApiKey("d92bb2a9e733e4e509fbf6b727d7cd00");
		fakeWeatherService.setApiLink("http://api.openweathermap.org/data/2.5/weather?q=");
		Weather result = fakeWeatherService.getWeather("Sydney");
		System.out.println(result.getCity()+" "+result.getTemperature()+" "+result.getWeatherDesc());
		
		//THEN
		assertNotNull(result);
	}

}


