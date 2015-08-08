package au.com.pactera.code.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import au.com.pactera.code.test.dto.City;
import au.com.pactera.code.test.dto.WeatherInfo;

@Service
public interface WeatherService {
	
	public WeatherInfo getWeather(String cityId) throws Exception;
	
	public List<City> getCities();
	
	public String getURL();
	
	public Map<String, String> getCitiesMap();

}
