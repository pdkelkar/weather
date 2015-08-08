/**
 * 
 */
package au.com.pactera.code.test.dto;

import java.util.List;

/**
 * @author Priyadarshan
 *
 */
public class WeatherApp {
	
	private String name;
	private Wind wind;
	private Main main;
	private List<Weather> weather;
	private long dt;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the wind
	 */
	public Wind getWind() {
		return wind;
	}
	/**
	 * @param wind the wind to set
	 */
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	/**
	 * @return the main
	 */
	public Main getMain() {
		return main;
	}
	/**
	 * @param main the main to set
	 */
	public void setMain(Main main) {
		this.main = main;
	}
	/**
	 * @return the weather
	 */
	public List<Weather> getWeather() {
		return weather;
	}
	/**
	 * @param weather the weather to set
	 */
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	
	public long getDt() {
		return dt;
	}
	public void setDt(long dt) {
		this.dt = dt;
	}
	
	
}
	
