/**
 * 
 */
package au.com.pactera.code.test.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import au.com.pactera.code.test.dto.City;
import au.com.pactera.code.test.dto.WeatherInfo;
import au.com.pactera.code.test.service.WeatherService;

/**
 * @author Priyadarshan
 *
 */
@Controller
public class WeatherController{
	
	private static final Logger	logger	= Logger.getLogger(WeatherController.class);
	
    @Autowired
    private WeatherService weatherService;
	
	@RequestMapping(value = "/cities", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<City> getCities() {
		logger.info("getCities()-Entry");		
		return weatherService.getCities();

	}

	@RequestMapping(value = "/today", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public WeatherInfo getCityWeather(@RequestBody String cityId) {
		logger.info("getCityWeather()-Entry");
		WeatherInfo currentWeather = new WeatherInfo();
		try {
			currentWeather = weatherService.getWeather(cityId);
		} catch (IOException e) {
			logger.error("IOException occured for getWeather() service"+ e);
		}
		catch (Exception e) {
			logger.error("General Exception occured for getWeather() service"+ e);
		}
		logger.info("getCityWeather()-Exit");
		return currentWeather;

	}

}
