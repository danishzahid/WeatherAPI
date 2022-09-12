package com.danish.weather.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danish.weather.exception.ResourceNotFoundException;
import com.danish.weather.model.Weather;
import com.danish.weather.repository.WeatherRepository;
import com.danish.weather.service.WeatherService;

@Service
@Transactional
public class WeatherSeviceImpl implements WeatherService{

	private WeatherRepository weatherRepository;
	
	@Autowired
	public WeatherSeviceImpl(WeatherRepository weatherRepository) {
		super();
		this.weatherRepository = weatherRepository;
	}



	@Override
	public Weather saveWeather(Weather weather) {
		return weatherRepository.save(weather);
	}
	
	@Override
	public List<Weather> getAllWeather(){
		return weatherRepository.findAll();
	}



	@Override
	public Weather getWeatherbyId(long id) {
		Optional<Weather> weather = weatherRepository.findById(id);
		if(weather.isPresent()) {
			return weather.get();
		}else {
			throw new ResourceNotFoundException("Weather", "Id", id);
		}
	}



	@Override
	public void deleteWeather(long id) {
		
		//check if record exists
		weatherRepository.findById(id).orElseThrow(()->
					new ResourceNotFoundException("Weather","id",id ));
		
		weatherRepository.deleteById(id);
		
	}
	

}
