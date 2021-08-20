package com.evertec.testingreso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="productos")
@AllArgsConstructor @NoArgsConstructor @Builder @Data
public class Producto {

	@Id
	@Column (name="idproducto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	
	@Column(name="codproducto", unique = true)
	@Size(min = 1, max = 10)
	@NotNull(message = "El codigo del producto no puede ser vacio. ")
	private String codProducto;
	
	@Column(name="nombre", nullable = false)
	@Size(min = 5, max = 100)
	@NotNull(message = "El nombre del producto no puede ser vacio. ")
	private String nombre;
	
}
