/**
 * 
 */
package au.com.pactera.code.test.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import au.com.pactera.code.test.dto.City;
import au.com.pactera.code.test.dto.WeatherApp;
import au.com.pactera.code.test.dto.WeatherInfo;
import au.com.pactera.code.test.exception.CityIdNotFoundException;
import au.com.pactera.code.test.util.WeatherUtil;
import au.com.pactera.code.test.validation.ValidationUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Priyadarshan
 * This class is the service class which implements WeatherService and performs required business logic
 */

@Service
public class WeatherServiceImpl implements WeatherService {

	private static final Logger	logger	= Logger.getLogger(WeatherServiceImpl.class);
	
	@Value("${weatherURL}")
	private String URL;

	@Value("#{citiesMap}")
	private Map<String, String> citiesMap;
	
	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public Map<String, String> getCitiesMap() {
		return citiesMap;
	}

	public void setCitiesMap(Map<String, String> citiesMap) {
		this.citiesMap = citiesMap;
	}

	@Override
	public WeatherInfo getWeather(String cityId) throws IOException, CityIdNotFoundException {
		logger.info("getWeather()- Entry");
		String currentWeather = "";
		WeatherApp weatherApp = new WeatherApp();
		WeatherInfo weatherInfo = new WeatherInfo();
		//call the WeatherAPI for weather information
		currentWeather = WeatherUtil.makeHTTPGetCall(cityId, URL);
		Gson gson = new GsonBuilder().create();
		//Convert json to WeatherApp java object
		weatherApp = gson.fromJson(currentWeather, WeatherApp.class);
		//Convert WeatherApp to WeatherInfo
		WeatherUtil.convertToWeatherInfo(weatherInfo, weatherApp);
		//Validate city id passed by UI
		ValidationUtil.checkCityId(weatherInfo);
		//Round off temp, speed values to one decimal place
		WeatherUtil.convertToOneDecimalPlace(weatherInfo);		
		logger.info("getWeather()- Exit");
		return weatherInfo;
	}

	@Override
	public List<City> getCities() {
		logger.info("getCities()- Entry");
		List<City> cities = new ArrayList<>();
		//convert Map to List
		WeatherUtil.convertToCityList(cities, citiesMap);
		logger.info("getCities()- Exit");
		return cities;
	}

}
