package com.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weather.model.Weather;
import com.weather.service.WeatherService;

@Controller
@EnableAutoConfiguration
public class WeatherController {

	@Value("#{'${weather.cityNames}'.split(';')}")
	private List<String> cityNames;
	
	@Autowired
	WeatherService weatherService;
	
	@RequestMapping(value="/weather", method=RequestMethod.GET)
    public String weatherForm(Model model, @RequestParam(value="location",required=false) String city) {
    	
        model.addAttribute("locations", cityNames);
        if(city!=null){
        	model.addAttribute("city", city);
            Weather weather = weatherService.getWeather(city);
            model.addAttribute("weather",weather);            
        }
        
        return "weather";
    }

    public List<String> getCityNames() {
		return cityNames;
	}

	public void setCityNames(List<String> cityNames) {
		this.cityNames = cityNames;
	}
	/*    @RequestMapping(value="/weather", method=RequestMethod.POST)
    public String weatherSubmit(@ModelAttribute("location") String city, Model model) {
        model.addAttribute("city", city);
        Weather weather = weatherService.getWeather(city);
        model.addAttribute("weather",weather);
        return "result";
    }*/

}