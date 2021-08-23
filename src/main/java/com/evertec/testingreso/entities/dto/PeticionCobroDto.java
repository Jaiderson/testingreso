package com.evertec.testingreso.entities.dto;

import com.evertec.testingreso.entities.Buyer;
import com.evertec.testingreso.entities.Payment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Builder
public class PeticionCobroDto {

	private WSAuthentication auth;
	private String locale;
	private Buyer buyer;
	private Payment payment;
	private String expiration;
	private String returnUrl;
	private String ipAddress;
	private String userAgent;
	
}
