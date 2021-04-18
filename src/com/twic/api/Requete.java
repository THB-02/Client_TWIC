package com.twic.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twic.modeles.Ville;

public class Requete {
	
	public Requete() {
		
	}
	
	public List<Ville> getVilles (){
		
		List<Ville> villes = new ArrayList<Ville>();
		
		try {

	        URL url = new URL("http://127.0.0.1:8181/ville");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");

	        if (conn.getResponseCode() != 200) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                    + conn.getResponseCode());
	        }

	        BufferedReader br = new BufferedReader(new InputStreamReader(
	            (conn.getInputStream())));

	        String output;
	        
	        while ((output = br.readLine()) != null) {
	        	JSONParser parser = new JSONParser();  
	        	try {
	        		
	        		
	        	    
					JSONArray json = (JSONArray) parser.parse(output);
					for(int i = 0; i<json.size(); i++) {
						ObjectMapper mapper = new ObjectMapper();
		        	    Ville ville = mapper.readValue(json.get(i).toString(), Ville.class);
						villes.add(ville);
		        	}
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	        	
	        }

	        conn.disconnect();

	      } catch (MalformedURLException e) {

	        e.printStackTrace();

	      } catch (IOException e) {

	        e.printStackTrace();

	      }
		return villes;
	}
	
	

}
