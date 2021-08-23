package com.evertec.testingreso.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Amount {

	private String currency;
	private double total;
	
}
