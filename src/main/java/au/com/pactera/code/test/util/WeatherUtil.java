/**
 * 
 */
package au.com.pactera.code.test.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import au.com.pactera.code.test.dto.WeatherApp;
import au.com.pactera.code.test.dto.WeatherInfo;

/**
 * @author Priyadarshan
 * 
 */
public class WeatherUtil {

	/*
	 * public static JSONObject extractJsonObject(String jsonObject) throws
	 * JSONException {
	 * 
	 * JSONObject json = new JSONObject(jsonObject); return json; }
	 * 
	 * public static String getStringValuefromJson(String
	 * jsonAttribute,JSONObject json) throws JSONException{ return
	 * (String)json.get(jsonAttribute); }
	 * 
	 * public static Double getDoubleValuefromJson(String
	 * jsonAttribute,JSONObject json) throws JSONException{ return
	 * (Double)json.get(jsonAttribute); }
	 */

	public static String makeHTTPGetCall(String parameter, String URL)
			throws IOException {

		String result = "";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			HttpGet httpget = new HttpGet(URL + parameter);

			try {

				response = httpclient.execute(httpget);
				result = convertEntityResponseToString(response);

			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
		return result;
	}

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
		weatherInfo.setTemp(StringUtils.isNotBlank(Double.toString(weatherApp
				.getMain().getTemp())) ? weatherApp.getMain().getTemp() : 0.0D);
		// CityWindspeed
		weatherInfo.setSpeed(StringUtils.isNotBlank(Double.toString(weatherApp
				.getWind().getSpeed())) ? weatherApp.getWind().getSpeed()
				: 0.0D);
		// CityCurrentcond
		weatherInfo.setCurrentCondition(StringUtils.isNotBlank(weatherApp
				.getWeather().get(0).getMain()) ? weatherApp.getWeather()
				.get(0).getMain() : "");

		return weatherInfo;

	}

}
