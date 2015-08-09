package au.com.pactera.code.test.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import au.com.pactera.code.test.dto.City;
import au.com.pactera.code.test.dto.WeatherApp;
import au.com.pactera.code.test.dto.WeatherInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/weatherDispatcher-servlet.xml" })

public class WeatherUtilTest {
	
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


	@Test
	public void testMakeHTTPGetCall() throws IOException {
		String result = null;
		result = WeatherUtil.makeHTTPGetCall("2147714", URL);
		assertNotNull(result);		
	}

	@Test
	public void testConvertToWeatherInfo() throws IOException {
		WeatherApp weatherApp = new WeatherApp();
		WeatherInfo weatherInfo = new WeatherInfo();
		String currentWeather = WeatherUtil.makeHTTPGetCall("2147714", URL);
		Gson gson = new GsonBuilder().create();
		weatherApp = gson.fromJson(currentWeather, WeatherApp.class);
		WeatherUtil.convertToWeatherInfo(weatherInfo, weatherApp);
		assertNotNull(weatherInfo);

	}

	@Test
	public void testConvertToCityList() {
		List<City> cityList = new ArrayList<>();
		cityList = WeatherUtil.convertToCityList(cityList, citiesMap);
		assertNotNull(cityList);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testConvertToOneDecimalPlace() {
		WeatherInfo weatherInfo = new WeatherInfo();
		weatherInfo.setTemp(25.27);
		weatherInfo.setSpeed(5.24);
		WeatherUtil.convertToOneDecimalPlace(weatherInfo);
		assertEquals(25.3, weatherInfo.getTemp(),0.0);
		assertEquals(5.2, weatherInfo.getSpeed(),0.0);
	}

}
