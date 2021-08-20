package com.evertec.testingreso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="clientes")
@AllArgsConstructor @NoArgsConstructor @Builder @Data
public class Cliente {

	@Id
	@Column (name="idcliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
	@Column(nullable = false, name="nombre")
	@Size(min = 10, max = 100)
	@NotNull(message = "El nombre del cliente no puede ser vacio. ")
	private String nombre;
	
	@Column(nullable = false, name="direccion")
	@Size(min = 10, max = 100)
	@NotNull(message = "La direccion del cliente no puede ser vacio. ")
	private String direccion;

	@Column(nullable = false, name="telefono")
	@Size(min = 5, max = 100)
	@NotNull(message = "El telefono del cliente no puede ser vacio. ")
	private String telefono;
	
	@Column(nullable = false, name="mail")
	@Size(min = 10, max = 100)
	@NotNull(message = "El email del cliente no puede ser vacio. ")
	@Email(message = "Formaro del email incorrecto. ")
	private String mail;

}
