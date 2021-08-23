package com.evertec.testingreso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="buyer")
@AllArgsConstructor @NoArgsConstructor @ToString @Builder @Data
public class Buyer {

	@Id
	@Column (name="buyer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBuyer;
	
	@Column(nullable = false, name="document_type")
	@NotNull(message = "El tipo de documento del cliente no puede ser vacio. ")
	private String documentType;
	
	@Column(nullable = false, name="document")
	@NotNull(message = "El numero de documento del cliente no puede ser vacio. ")
	private String document;
	
	@Column(nullable = false, name="name")
	@NotNull(message = "El nombre del cliente no puede ser vacio. ")
	private String name;
	
	@Column(nullable = false, name="surname")
	@NotNull(message = "El apellido del cliente no puede ser vacio. ")
	private String surname;
	
	@Column(nullable = false, name="email")
	@NotNull(message = "El email del cliente no puede ser vacio. ")
	private String email;
	
	@Column(nullable = false, name="mobile")
	@NotNull(message = "El numero de celular del cliente no puede ser vacio. ")
	private String mobile;

}
