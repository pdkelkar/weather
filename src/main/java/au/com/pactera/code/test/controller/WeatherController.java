package au.com.pactera.code.test.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import au.com.pactera.code.test.dto.City;
import au.com.pactera.code.test.dto.WeatherInfo;
import au.com.pactera.code.test.exception.CityIdNotFoundException;
import au.com.pactera.code.test.service.WeatherService;

/**
 * @author Priyadarshan
 * This is the main Controller class which serves as entry point for UI
 *
 */
@Controller
public class WeatherController{
	
	private static final Logger	logger	= Logger.getLogger(WeatherController.class);
	
    @Autowired
    private WeatherService weatherService;
    
	@Value("${error.cityId}")
	private String cityIdError;

	/**
	 * 
	 * @return list of cities for UI drop down
	 */
	@RequestMapping(value = "/cities", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<City> getCities() {
		logger.info("getCities()-Entry");		
		return weatherService.getCities();

	}

	/**
	 * 
	 * @param cityId
	 * @return
	 * @throws CityIdNotFoundException
	 */
	@RequestMapping(value = "/today", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public WeatherInfo getCityWeather(@RequestBody String cityId) throws CityIdNotFoundException {
		logger.info("getCityWeather()-Entry");
		WeatherInfo currentWeather = new WeatherInfo();
		try {
			currentWeather = weatherService.getWeather(cityId);
		} catch (IOException e) {
			logger.error("IOException occured for getWeather() service"+ e);
		} 
		logger.info("getCityWeather()-Exit");
		return currentWeather;
	}
	
	/**
	 * Controller exception handler method for City Id error
	 */
	  @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="${error.cityId}")// HTTP 400 error
	  @ExceptionHandler(CityIdNotFoundException.class)
	  public void cityIdError() {
	    logger.error(getCityIdError());
	  }

	/**
	 * @return the cityIdError
	 */
	public String getCityIdError() {
		return cityIdError;
	}

	/**
	 * @param cityIdError the cityIdError to set
	 */
	public void setCityIdError(String cityIdError) {
		this.cityIdError = cityIdError;
	}

}
