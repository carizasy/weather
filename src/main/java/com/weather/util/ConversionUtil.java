package com.weather.util;

public class ConversionUtil {

	public static double kelvinToCelcius(double kelv){
		//The temperature T in degrees Celsius (°C) is equal to the temperature T in Kelvin (K) minus 273.15
		return (kelv-273.15);
	}
	
	public static double windMPStoKPH(double mps){
		//1 metre per second (m/s, ms-1)	=	3.60 kilometres per hour (kph)
		return (mps * 3.60);
	}
}
