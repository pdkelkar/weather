/**
 * 
 */
package au.com.pactera.code.test.dto;

import java.io.Serializable;

/**
 * @author Priyadarshan
 *
 */
public class WeatherInfo implements Serializable{
	
	private static final long serialVersionUID = -6439624701016262342L;
	private String cityName;
	private long dt;
	private double temp;
	private double speed;
	private String currentCondition;
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * @return the dt
	 */
	public long getDt() {
		return dt;
	}
	/**
	 * @param dt the dt to set
	 */
	public void setDt(long dt) {
		this.dt = dt;
	}
	/**
	 * @return the temp
	 */
	public double getTemp() {
		return temp;
	}
	/**
	 * @param temp the temp to set
	 */
	public void setTemp(double temp) {
		this.temp = temp;
	}
	/**
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}
	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	/**
	 * @return the currentCondition
	 */
	public String getCurrentCondition() {
		return currentCondition;
	}
	/**
	 * @param currentCondition the currentCondition to set
	 */
	public void setCurrentCondition(String currentCondition) {
		this.currentCondition = currentCondition;
	}
	
}
