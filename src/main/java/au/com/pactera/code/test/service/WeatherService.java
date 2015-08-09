package au.com.pactera.code.test.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import au.com.pactera.code.test.dto.City;
import au.com.pactera.code.test.dto.WeatherInfo;
import au.com.pactera.code.test.exception.CityIdNotFoundException;
/**
 * 
 * @author Priyadarshan
 *
 */
@Service
public interface WeatherService {
	
	public WeatherInfo getWeather(String cityId) throws IOException, CityIdNotFoundException;
	
	public List<City> getCities();
	
	public String getURL();
	
	public Map<String, String> getCitiesMap();

}
