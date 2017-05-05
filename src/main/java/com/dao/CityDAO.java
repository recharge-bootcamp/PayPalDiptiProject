package com.dao;

import java.util.List;
import java.util.Map;





public interface CityDAO {

	//public List<Map<String ,Object>> listCities();
	public List<Mp<Striang, Object>> listCities();
	public List<Map<String,Object>> movieCities(String city);
	public List<Map<String, Object>> threatreList(String movie);
	
	public void updateWithseats(String seats,String theatreID);
	public List<Map<String,Object>> getTheatreID(String theatre);
	
}
