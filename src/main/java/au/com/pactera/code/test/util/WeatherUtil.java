package au.com.pactera.code.test.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import au.com.pactera.code.test.dto.City;
import au.com.pactera.code.test.dto.WeatherApp;
import au.com.pactera.code.test.dto.WeatherInfo;

/**
 * @author Priyadarshan
 * A utility class called by WeatherServiceImpl
 */
public class WeatherUtil {

	/**
	 * 
	 * @param parameter
	 * @param URL
	 * @return
	 * @throws IOException
	 */
	public static String makeHTTPGetCall(String parameter, String URL)
			throws IOException {

		String result = "";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			HttpGet httpget = new HttpGet(URL + parameter);

			try {
				//Make HTTP Get call
				response = httpclient.execute(httpget);
				//convert entity response to string
				result = convertEntityResponseToString(response);

			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
		return result;
	}

	/**
	 * 
	 * @param response
	 * @return String representation of Entity Response
	 * @throws IOException
	 */
	public static String convertEntityResponseToString(
			CloseableHttpResponse response) throws IOException {
		String line;
		StringBuffer result = new StringBuffer();
		if (null != response) {
			HttpEntity entity = response.getEntity();
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					entity.getContent()));
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			EntityUtils.consume(entity);
		}
		return result.toString();
	}

	/**
	 * 
	 * @param weatherInfo
	 * @param weatherApp
	 * @return WeatherInfo object
	 */
	public static WeatherInfo convertToWeatherInfo(WeatherInfo weatherInfo,
			WeatherApp weatherApp) {
		// Cityname
		weatherInfo
				.setCityName(StringUtils.isNotBlank(weatherApp.getName()) ? weatherApp
						.getName() : "");
		// Date
		weatherInfo.setDt(StringUtils.isNotBlank(Long.toString(weatherApp
				.getDt())) ? weatherApp.getDt() : 0L);

		// Citytemp
		weatherInfo.setTemp(weatherApp.getMain() != null ? weatherApp.getMain()
				.getTemp() : 0.0D);

		// CityWindspeed
		weatherInfo.setSpeed(weatherApp.getWind() != null ? weatherApp
				.getWind().getSpeed() : 0.0D);

		// CityCurrentcond
		weatherInfo
				.setCurrentCondition(weatherApp.getWeather() != null ? weatherApp
						.getWeather().get(0).getMain()
						: "");

		return weatherInfo;

	}

	/**
	 * 
	 * @param cities
	 * @param citiesMap
	 * @return
	 */
	public static List<City> convertToCityList(List<City> cities,
			Map<String, String> citiesMap) {
		for (Map.Entry<String, String> entry : citiesMap.entrySet()) {
			City city = new City();
			city.setCityId(entry.getKey());
			city.setCityName(entry.getValue());
			cities.add(city);
		}
		return cities;
	}
	
	/**
	 * 
	 * @param weatherInfo
	 * @return
	 */
	public static WeatherInfo convertToOneDecimalPlace(WeatherInfo weatherInfo){
		DecimalFormat oneDigit = new DecimalFormat("#,##0.0");//format to 1 decimal place
		weatherInfo.setTemp(Double.valueOf(oneDigit.format(weatherInfo.getTemp())));
		weatherInfo.setSpeed(Double.valueOf(oneDigit.format(weatherInfo.getSpeed())));
		return weatherInfo;
	}

}
