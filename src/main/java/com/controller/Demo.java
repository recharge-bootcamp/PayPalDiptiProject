package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CityImpl;














@RestController

public class Demo {
 private String movieName;
	
	@Autowired 
	CityImpl citiImpl;
	
	@RequestMapping("hello")
	
	
	public ModelAndView showMessage() {
		ModelAndView model = null;
		try {
			
			List<Map<String, Object>> myListOfMaps = new ArrayList<Map<String, Object>>();
			//List<ity>C myListOfMaps = new ArrayList<City>();
			
			myListOfMaps = citiImpl.listCities(); 
			System.out.println("Hi...");
			
			 // this is what you have already
			Map citiMap = new HashMap();
			for (Map<String, Object> map : myListOfMaps) {
			    for (Map.Entry<String, Object> entry : map.entrySet()) {
			        String key = entry.getKey();
			        
			        System.out.println("first"+key);
			       
			        Object value = entry.getValue();
			        System.out.println("second"+value);
			        citiMap.put(value, key);
			        
			        
			        
			        
			    }
			}
			
			model = new ModelAndView("hello", "dropDownItems",citiMap);
			
		}
			
		
			
			
			/*
			Map<String, String> sampleDropdownMap = new HashMap<String, String>();
			sampleDropdownMap.put("Java", "java");
			sampleDropdownMap.put("PHP", "php");
			
		} */
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}


	@RequestMapping("showmovies") 
	
	public ModelAndView getSelectedvalue(@RequestParam(value="item") String city) 
			{
				
		System.out.println("Hi.....2");
		System.out.println(city);
		List<Map<String, Object>> myListOfMaps1 = new ArrayList<Map<String, Object>>();
				//System.out.println(Querymap);
		
				
				//City movieCity = new City();
				//movieCity.setCityName(city);
				myListOfMaps1=citiImpl.movieCities(city);
				Map movieMap = new TreeMap();
				
				for (Map<String, Object> map : myListOfMaps1) {
				    for (Map.Entry<String, Object> entry : map.entrySet()) {
				        String key = entry.getKey();
				        
				        System.out.println("first"+key);
				       
				        Object value = entry.getValue();
				        System.out.println("second"+value);
				        movieMap.put(value,key);
				      
				    }
				    
				    
				}
				
				
				return new ModelAndView("showmovies","moviemap",movieMap);
		
			}
	
/*****************For theatres***********************/
	
@RequestMapping("theatres") 
	
	public ModelAndView getSelectedTheatre(@RequestParam(value="item") String movie, Model model,HttpSession session) 
			{
			
		System.out.println("Hi.....2");
		//model.addAttribute(movie);
		session.setAttribute("mysession", movie);
		//System.out.println(city);
		List<Map<String, Object>> myListOfMaps2 = new ArrayList<Map<String, Object>>();
		Integer result=null;
				//System.out.println(Querymap);
		
				
				//City movieCity = new City();
				//movieCity.setCityName(city);
				myListOfMaps2=citiImpl.threatreList(movie);
				model.addAttribute(movie);
				Map movieMap1 = new TreeMap();
				
				for (Map<String, Object> map1 : myListOfMaps2) {
				    for (Map.Entry<String, Object> entry : map1.entrySet()) {
				        String key = entry.getKey();
				        
				        System.out.println("first"+key);
				       
				       
				        Object value = entry.getValue();
				       
				        System.out.println("second"+value);
				       
				        movieMap1.put(value,key);
				        
				    }
				    
				    
				}
				
				
				return new ModelAndView("theatres","movieMap1",movieMap1);
		
			}
	
	/*********************************Test*****************************/
@RequestMapping("test") 

public ModelAndView getSeats(@RequestParam(value="item") String price, Model model,HttpSession session) 
		{
		
	System.out.println("Hi from test");
	//System.out.println(city);
    String str=(String) session.getAttribute("mysession");
    System.out.println("Session Attribute"+str);
	Set set=new TreeSet();
	List<Map<String, Object>> myListOfMaps3= new ArrayList<Map<String, Object>>();
	List<Map<String, Object>> lisOfTheatreIDs= new ArrayList<Map<String,Object>>();
	Map valueMap= new TreeMap();
	Integer result=null;
	int actualPrice=0;
	String theatreName=null;
			//System.out.println(Querymap);
	
			
			//City movieCity = new City();
			//movieCity.setCityName(city);
			//Map<String, Object> stringModel =model.asMap();
			//Map.Entry<String,Object> modelEntry=stringModel.entrySet().iterator().next();
			//String modelKey= modelEntry.getKey();
			//String modelValue =modelEntry.getValue().toString();
			//System.out.println("MODEL"+modelKey);
			//System.out.println("MODEL"+modelValue);
			myListOfMaps3=citiImpl.threatreList(str);
			Map movieMap2 = new TreeMap();
			//Map<String ,Object> valueMap =(Map<String, Object>) myListOfMaps3;
			
			
			String flag =null;
		    int  flag1=0;
		    Object value1=null;
			for (Map<String, Object> map2 : myListOfMaps3) {
				 //set = map2.entrySet();
			    for (Map.Entry<String, Object> entry1 : map2.entrySet()) {
			        String key = entry1.getKey();
			        
			       flag=entry1.getKey();
			        System.out.println("first"+key);
			    	
			       
			       
			        Object value = entry1.getValue();
			       
			        System.out.println("second"+value);
			        
			        value1=value;
			        
			        //movieMap2.put(value,key);
			        
			    }
			    
			    
			}
		     /*set=valueMap.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext())
			{
				Map.Entry me = (Map.Entry)it.next();
				System.out.print(me.getKey() + "It should come here ");
		        System.out.println(me.getValue());
			}*/
			
			
			System.out.println("VALUE OF KEY IS"+flag);
			
			System.out.println(value1.toString());
			flag1=Integer.parseInt((String) value1);
			
			System.out.println("VALUE OF Value IS"+flag1);
			actualPrice=  Integer.parseInt(price);
			flag1=flag1-actualPrice;
			actualPrice=  Integer.parseInt(price);
			actualPrice= actualPrice*100;
			
			for(Object o:set)
			{
				System.out.println("I am in for"+o.toString());
				theatreName=o.toString();
				
				
			}
			Object obj=	myListOfMaps3.get(0).get("theatreName");
			String theatre =obj.toString();
			System.out.println("Theatre is "+theatre);
			
			lisOfTheatreIDs=citiImpl.getTheatreID(theatre);
			Object obj1=lisOfTheatreIDs.get(0).get("theatreID");
			String theatreID = obj1.toString();
			System.out.println("Theatre ID is"+ obj1);
			
			System.out.println("In if clause"+theatreName);
			
			//movieMap2.put(flag1,flag1);
			String strValue = String.valueOf(flag1);
			
			
			
			System.out.println("Deducted value is"+strValue);
			citiImpl.updateWithseats(strValue,theatreID);
			
			movieMap2.put(actualPrice,flag1);
			
			return new ModelAndView("test","movieMap1",movieMap2);
	
		}






	
	
	
	
	

	
	
	
	
	@RequestMapping("/")
	public ModelAndView showLandingPage() {
		ModelAndView model = null;
		try {
			model = new ModelAndView("index");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
}