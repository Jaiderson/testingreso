package com.evertec.testingreso.entities.dto;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class WSAuthentication {

	private String login;
	private String tranKey;
	private String nonce;
	private String seed;

	public WSAuthentication(String login, String tranKey) {
		this.login = login;
		this.tranKey = tranKey;
		this.generate();
	}

    /**
     * Invoque this function each time that you use this class to generate a WS call
     * this will save the need to construct a new class every time
     * @return
     */
    public WSAuthentication generate() {
        this.nonce = new BigInteger(130, new SecureRandom()).toString();
        this.seed = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ", Locale.getDefault())).format(new Date());
        return this;
    }

}
