package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class ConsumeAPIController {
	@RequestMapping(value = "/countries")
	public List<Object> getAllCountries()
	{
		List<Object> countries = null;

		try{
			String uri = "https://restcountries.com/v3.1/all";
			RestTemplate restTemplate = new RestTemplate();
			countries = Arrays.asList(restTemplate.getForObject(uri, Object[].class));
		}
		catch (Exception ex) {

		}
		return countries;
	}
}
