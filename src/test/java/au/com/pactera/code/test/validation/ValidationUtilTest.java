/**
 * 
 */
package au.com.pactera.code.test.validation;

import org.junit.Test;

import au.com.pactera.code.test.dto.WeatherInfo;
import au.com.pactera.code.test.exception.CityIdNotFoundException;

/**
 * @author L071987
 *
 */
public class ValidationUtilTest {

	/**
	 * Test method for {@link au.com.pactera.code.test.validation.ValidationUtil#checkCityId(au.com.pactera.code.test.dto.WeatherInfo)}.
	 * @throws CityIdNotFoundException 
	 */
	@Test(expected=CityIdNotFoundException.class)
	public void testCheckCityId() throws CityIdNotFoundException {
		WeatherInfo weatherInfo = new WeatherInfo();
		ValidationUtil.checkCityId(weatherInfo);
		
	}

}
