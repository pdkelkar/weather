package au.com.pactera.code.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import au.com.pactera.code.test.dto.City;
import au.com.pactera.code.test.dto.WeatherInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/weatherDispatcher-servlet.xml" })
public class WeatherServiceImplTest {
	
	@Autowired
	private WeatherService weatherService;

	@Test
	public void testGetWeather() {
		WeatherInfo weatherInfo = null;
		try {
			weatherInfo = weatherService.getWeather("2158177");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		assertNotNull(weatherInfo);
	}

	@Test
	public void testGetURL() {
		String url1 = weatherService.getURL();
		assertNotNull(url1);
	}

	@Test
	public void testGetCitiesMap() {
		Map<String,String> map1 = weatherService.getCitiesMap();
		assertNotNull(map1);
	}

	@Test
	public void testGetCities() {
		List<City> cities1 = weatherService.getCities();
		assertNotNull(cities1);
	}

}
