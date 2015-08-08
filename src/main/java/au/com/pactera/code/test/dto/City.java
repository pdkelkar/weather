package au.com.pactera.code.test.dto;

import java.io.Serializable;

public class City implements Serializable {

	private static final long serialVersionUID = -2964161927470567098L;
	
	private String cityId;
	private String cityName;
	/**
	 * @return the cityId
	 */
	public String getCityId() {
		return cityId;
	}
	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
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

}
