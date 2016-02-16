package com.example.weatherjson;

public class Weather {
	private double lon, lat, temp;
	private String capital, country;
	private int pic;
	
	
	
	public Weather(double lon, double lat, double temp, String capital,
			String country, int pic) {
		super();
		this.lon = lon;
		this.lat = lat;
		this.temp = temp;
		this.capital = capital;
		this.country = country;
		this.pic = pic;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPic() {
		return pic;
	}
	public void setPic(int pic) {
		this.pic = pic;
	}
	
	
}
