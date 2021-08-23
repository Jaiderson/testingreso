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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="orden_compras")
@AllArgsConstructor @ToString @Builder @Data
public class OrdenCompra {

	public OrdenCompra() {
		super();
		this.cliente = new Cliente();
		this.producto = new Producto();
		this.pago = new Pago();
	}

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
	private Producto producto;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpago")
	private Pago pago;

	@Column(name="cantidad")
	@Positive(message = "La cantidad debe ser positiva. ")
	private Integer cantidad;

	@Column(name="valor")
	@Positive(message = "El valor debe ser positivo. ")
	private Double valorCompra;
	
}
