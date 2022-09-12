package com.danish.weather.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danish.weather.model.Weather;
import com.danish.weather.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

	private WeatherService weatherService;

	public WeatherController(WeatherService weatherService) {
		super();
		this.weatherService = weatherService;
	}
	
	
  //build create weather REST API
	@PostMapping
	public ResponseEntity<Weather> saveWeather(@RequestBody Weather weather){
		return new ResponseEntity<Weather>(weatherService.saveWeather(weather), HttpStatus.CREATED);
	}
	
  //build get all weather record in Rest API
	@GetMapping
	public List<Weather> getAllWeather(){
		return weatherService.getAllWeather();
	}
	
  //build get weather by id Rest API
	@GetMapping("{id}")
	public ResponseEntity<Weather> getWeatherById(@PathVariable("id") long id){
		return new ResponseEntity<Weather>(weatherService.getWeatherbyId(id),HttpStatus.OK );
	}
	
  //build Delete weather by id Rest API
	@DeleteMapping({"{id}"})
	public ResponseEntity<String> deleteWeather(@PathVariable("id") long id){
		weatherService.deleteWeather(id);
		return new ResponseEntity<String>("Weather Record deleted successfully!", HttpStatus.NO_CONTENT);
	}
 
}
 