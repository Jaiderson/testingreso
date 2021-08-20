package com.evertec.testingreso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orden_compras")
@AllArgsConstructor @NoArgsConstructor @Builder @Data
public class OrdenCompra {

	@Id
	@Column (name="idorden")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrden;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcliente")
	@NotNull(message = "Debe especificar el cliente.")
	private Cliente cliente;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproducto")
	@NotNull(message = "Debe especificar el producto.")
	private Producto proucto;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpago")
	private Pago pago;

	@Column(name="cantidad")
	@Size(min = 1)
	@Positive(message = "La cantidad debe ser positiva. ")
	private int cantidad;

	@Column(name="valor")
	@Size(min = 1)
	@Positive(message = "El valor debe ser positivo. ")
	private double valorCompra;

	
}
