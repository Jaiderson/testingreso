package com.evertec.testingreso.entities;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

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
import lombok.ToString;

@Entity
@Table(name="pagos")
@AllArgsConstructor @ToString @Builder @Data
public class Pago {

	public static final String ESTADO_REEJECUTADO = "REJECTED";
	public static final String ESTADO_CREADO = "CREATED";
	public static final String ESTADO_PAGADO = "PAYED";

	public Pago() {
		this.estado = ESTADO_CREADO;
		LocalDateTime fechaCrea = LocalDateTime.now();
		this.fechaCreacion = Date.from(fechaCrea.atZone(ZoneId.systemDefault()).toInstant());
		this.detalle = estado + "|" + fechaCrea.toString();
	}

	@Id
	@Column (name="idpago")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPago;

	@Column(name="estado")
	@Size(min = 5, max = 10, message = "El estado del pago debe tener minimo 5 caracteres. ")
	@NotNull(message = "El estado del pago no puede ser vacio. ")
	private String estado;

	@Column(name="fecreacion")
	@NotNull(message = "Debe registrar fecha de creación del registro  de pago. ")
	private Date fechaCreacion;

	@Column(name="fepago")
	private Date fechaPago;
	
	@Column(name="detalle")
	@Size(min = 5, max = 500, message = "El detalle debe tener minimo 5 caracteres. ")
	@NotNull(message = "El detalle del pago no puede ser vacio. ")
	private String detalle;

}
