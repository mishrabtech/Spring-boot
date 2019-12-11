package com.Repository;


import org.springframework.stereotype.Component;

import com.Dao.EntityBean;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;



@Component
public class EmpDao {
	
	

 public	String getUrlData(String servUrl) {
	 String strRes="";
	 
		try {
			// setting for browser
			System.setProperty("jsse.enableSNIExtension", "false");
			System.out.println("server url is>>>>== "+servUrl);
			// create client
			Client client = Client.create();
			WebResource webResource = client.resource(servUrl);
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			System.out.println("server url is+++ "+servUrl);
			// check the status of response
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed: " + response.getStatus());
			}

			// getting response as string
			strRes=response.getEntity(String.class);
			
			//return response.getEntity(String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strRes;
	}
 public String dataValidate(String output) {
		try {
			output = output.replace("<hr />","");
			output = output.replace("<br /><hr />", "");
			//output = output.replace("}", "},");
			//output = "[" + output + "]";
			return output.replace("},]", "}]");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
 EntityBean[] jsonMapping(String output) {
	 EntityBean[] entityBeans = null;
		try {
			Gson gson = new Gson();
			entityBeans = gson.fromJson(output, EntityBean[].class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entityBeans;
	}


}
