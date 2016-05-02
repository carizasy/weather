package org.openweathermap.model;

import java.util.List;

/**
 * Object representation of API call from openweathermap
 * @author carizasy
 *
 */
public class WeatherForecast {
	
	//COORD
	public static class Coord{
		private Double lon;
		private Double lat;
		
		public Double getLon() {
			return lon;
		}
		public void setLon(Double lon) {
			this.lon = lon;
		}
		public Double getLat() {
			return lat;
		}
		public void setLat(Double lat) {
			this.lat = lat;
		}

	}
	
	
	//WEATHER
	public static class WeatherDesc{

			private long id;
			private String main;
			private String description;
			
			public long getId() {
				return id;
			}
			public void setId(long id) {
				this.id = id;
			}
			public String getMain() {
				return main;
			}
			public void setMain(String main) {
				this.main = main;
			}
			public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}

		
	}

	public static class Main{
		/**
		 * KELVIN
		 */
		//TODO convert itech to celcius
		private Double temp;

		public Double getTemp() {
			return temp;
		}

		public void setTemp(Double temp) {
			this.temp = temp;
		}
		
		
	}
	
	public static class Wind{
		private double speed;
		private double deg;
		
		public double getSpeed() {
			return speed;
		}
		public void setSpeed(double speed) {
			this.speed = speed;
		}
		public double getDeg() {
			return deg;
		}
		public void setDeg(double deg) {
			this.deg = deg;
		}
			
	}

	private Coord coord;

	private List<WeatherDesc> weather;
	
	private Main main;

	private Wind wind;
	
	private String name;

	private long id;
	
	private long cod;

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	

	public List<WeatherDesc> getWeather() {
		return weather;
	}

	public void setWeather(List<WeatherDesc> weather) {
		this.weather = weather;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	
	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCod() {
		return cod;
	}

	public void setCod(long cod) {
		this.cod = cod;
	}
	
	
	
	
}
