package com.danish.weather.service;

import java.util.List;

import com.danish.weather.model.Weather;


public interface WeatherService {

	Weather saveWeather(Weather weather);
	List<Weather> getAllWeather();
	Weather getWeatherbyId(long id);
	void deleteWeather(long id);
}
