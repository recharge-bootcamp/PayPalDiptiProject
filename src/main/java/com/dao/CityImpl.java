package com.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.dao.*;



public class CityImpl implements CityDAO {
	

public DataSource datasource; 
	   private JdbcTemplate jdbcTemplate;
	   
	   public CityImpl()
	   {
		   
	   }
	    public CityImpl(DataSource dataSource) {
	        jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	    
	    

		
		public DataSource getDatasource() {
			return datasource;
		}
		public void setDatasource(DataSource datasource) {
			this.datasource = datasource;
		}
		public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
		public List<Map<String, Object>> listCities() {
			//TODO Auto-generated method stub
			return jdbcTemplate.queryForList("select cityName from city");
			
		}
		
		/*public List<Map<String, Object>> movieCities(String cityName)
		{
			return jdbcTemplate.queryForList( "select city_name, movie_name from movie_city where cityname = ?");
			
		}*/
		public List<Map<String, Object>> movieCities(String city) {
			// TODO Auto-generated method stub
			//String selectedCity = city.getCityName();
			return jdbcTemplate.queryForList( "select  moviename from movie_city where cityName = '"+city+"'");
			
		}
	/*	public List<Map<String, Object>> threatreList(String movie) {
			
			return jdbcTemplate.queryForList("select theatreName  from movietheatre where moviename = '"+movie+"'");
			
		
		}*/
		
			public List<Map<String, Object>> threatreList(String movie) {
			
			return jdbcTemplate.queryForList( "select theatreName, seat from theatre t, movie_theatre m where t.theatreID = m.theatreID and m.moviename = '"+movie+"'");
				
			}
			
			public List<Map<String,Object>> getTheatreID(String theatre)
			{
				return jdbcTemplate.queryForList("select theatreID from theatre t where theatreName='"+theatre+"'");
				
			}
			
			
			
			
			public void updateWithseats(String seats, String theatreID) {
				
				
				jdbcTemplate.update(
		                "update movie_theatre set seat='"+seats+"' where theatreID='"+theatreID+"'");
				
			}

			
			
		
		/*
		public List<City> listCities()
		{
			
			List<City> city = new ArrayList<City>();
			String sql= "Select * from City";
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
			for(Map row :rows)
			{
				City city1 = new City();
				city1.setCityID((String )row.get("city_ID"));
				city1.setCityName((String)row.get("city_name"));
				city.add(city1);
				
			}
			
			
			
			
			
			return city;
		}*/
		
		
		
			
			
		}
	 
	
	
