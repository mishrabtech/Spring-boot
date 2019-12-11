package com.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.EntityBean;
import com.Repository.EmpDao;

import com.google.gson.Gson;

@RestController
public class DataSendWithURLController {

	@Autowired
	public EmpDao empdao;

	@Autowired
	EntityBean entbean;

	@RequestMapping("/dataFetchFromDB")
	@ResponseBody
	public ModelAndView dataFetchFromDB(ModelAndView model) throws IOException {
		System.out.println("enter in fetch");
		String displaydata = "";
		try {
			String servUrl = "http://10.23.21.97:8081/employees/fetchEmp";
			System.out.println("server url is " + servUrl);
			displaydata = empdao.getUrlData(servUrl);
			System.out.println("displaydata is " + displaydata);
			EntityBean[] entityBeans = null;
			Gson gson = new Gson();
			entityBeans = gson.fromJson(displaydata, EntityBean[].class);
			// System.out.println("entityBeans data "+entityBeans.getItem[1]);
			model.addObject("data", entityBeans);
			model.setViewName("teamlead");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	// Method to save an Employee
	@RequestMapping("getAndSave")
	public ModelAndView dataInsertInDB(@RequestParam("empname") String empname, @RequestParam("empcom") String empcom,
			@RequestParam("empmob") String empmob, @RequestParam("empemail") String empemail)
			throws IOException, URISyntaxException {
		System.out.println(
				"Emp Name" + empname + "Emp company=>" + empcom + "Mobile No=>" + empmob + "email=>" + empemail);
//		{
//		    "empname": "Chandan Mishra",
//		    "empcom": "velocis fgdgrg Pvt Ltd",
//		    "empmob": "9865325689",
//		    "empemail": "chandan@gmail.com"
//		}
		String finaldata = " {empname:" + empname + ", empcom:" + empcom + ", empmob:" + empmob + ",empemail:"
				+ empemail + "}";
		System.out.println("finaldata" + finaldata);
		String servUrlInsert = "http://10.23.21.97:8081/employees/empAdd";
		System.out.println("enter in controller save url" + servUrlInsert);
		entbean.setEmpname(empname);
		entbean.setEmpcom(empcom);
		entbean.setEmpmob(empmob);
		entbean.setEmpemail(empemail);
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI(servUrlInsert);
		ResponseEntity<String> result = restTemplate.postForEntity(uri, entbean, String.class);
		return new ModelAndView("index");
	}

	// Method to Update and save Employee data
	@RequestMapping(value ="getAndUpdate",method = RequestMethod.GET)
	public ModelAndView update(@RequestParam("empname") String empname, @RequestParam("empcom") String empcom,
			@RequestParam("empmob") String empmob, @RequestParam("empemail") String empemail,
			@RequestParam("id") int id)
			throws IOException, URISyntaxException {
		System.out.println("Emp Name" + empname + "Emp company=>" + empcom + "Mobile No=>" + empmob + "email=>" + empemail+"id>>");
		String finaldata = " {empname:" + empname + ", empcom:" + empcom + ", empmob:" + empmob + ",empemail:"
				+ empemail + "}";
		System.out.println("finaldata update" + finaldata);
		String servUrlInsert = "http://10.23.21.97:8081/employees/update";
		System.out.println("enter in controller Update url" + servUrlInsert);
		entbean.setEmpname(empname);
		entbean.setEmpcom(empcom);
		entbean.setEmpmob(empmob);
		entbean.setEmpemail(empemail);
		entbean.setId(id);
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI(servUrlInsert);
		ResponseEntity<String> result = restTemplate.postForEntity(uri, entbean, String.class);
		return new ModelAndView("teamlead");
	}

//		
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView updateData(@PathVariable("id") int upId) {
		ModelAndView model = new ModelAndView("updateEmp");
		System.out.println("upId==<>" + upId);
		System.out.println("enter in update Method<<<>>>");

		System.out.println("data fetch by ID for updation");
		String displaydataById = "";
		try {
			String servUrl = "http://10.23.21.97:8081/employees/fetchById/" + upId;
			System.out.println("server url is " + servUrl);
			displaydataById = empdao.getUrlData(servUrl);
			System.out.println("displaydata by id " + displaydataById);

			EntityBean entityBeans = null;
			Gson gson = new Gson();
			entityBeans = gson.fromJson(displaydataById, EntityBean.class);
			// System.out.println("entityBeans data "+entityBeans.getItem[1]);
			model.addObject("data", entityBeans);
			// model.setViewName("updateEmp");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}

	// delete method

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		System.out.println("id==>" + id);
		entbean.setId(id);
		String servUrlInsert = "http://10.23.21.97:8081/employees/delById/" + id;
		System.out.println("enter in delete  url" + servUrlInsert);

		RestTemplate restTemplate = new RestTemplate();
		URI url;
		try {
			url = new URI(servUrlInsert);
			System.out.println("url>>" + url + "id==>" + id);
			ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
			System.out.println("delete method " + result);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// dao.delete(id);
		// productService.delete(id);
		return new ModelAndView("index");
	}

}