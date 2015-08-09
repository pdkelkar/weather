/**
 * 
 */
package au.com.pactera.code.test.validation;

import org.apache.commons.lang3.StringUtils;

import au.com.pactera.code.test.dto.WeatherInfo;
import au.com.pactera.code.test.exception.CityIdNotFoundException;

/**
 * @author Priyadarshan
 *
 */
public class ValidationUtil {
	
	public static void checkCityId(WeatherInfo weatherInfo) throws CityIdNotFoundException{
		if(StringUtils.isBlank(weatherInfo.getCityName()) || StringUtils.isBlank(weatherInfo.getCurrentCondition())){
			throw new CityIdNotFoundException();
		}
	}

}
