package au.com.pactera.code.test.validation;

import org.apache.commons.lang3.StringUtils;

import au.com.pactera.code.test.dto.WeatherInfo;
import au.com.pactera.code.test.exception.CityIdNotFoundException;

/**
 * @author Priyadarshan
 * A utility class called by WeatherServiceImpl
 */
public class ValidationUtil {
	
	/**
	 * 
	 * @param weatherInfo
	 * @throws CityIdNotFoundException
	 */
	public static void checkCityId(WeatherInfo weatherInfo) throws CityIdNotFoundException{
		if(StringUtils.isBlank(weatherInfo.getCityName()) || StringUtils.isBlank(weatherInfo.getCurrentCondition())){
			throw new CityIdNotFoundException();
		}
	}

}
