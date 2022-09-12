package com.danish.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.danish.weather.model.Weather;


public interface WeatherRepository extends JpaRepository<Weather,Long>{

}
