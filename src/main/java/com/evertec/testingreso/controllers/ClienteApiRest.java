package com.evertec.testingreso.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClienteApiRest {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/template/clientes/{idCliente}", method=RequestMethod.GET)
	public String getCliente(@PathVariable("idCliente") long idCliente) {
		String url = "http://localhost:8091/clientes/"+idCliente;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> httpEntity = new HttpEntity<String>(headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
		return responseEntity.getBody();
	}

}
