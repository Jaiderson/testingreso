package com.evertec.testingreso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.evertec.testingreso.entities.dto.Amount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="payment")
@AllArgsConstructor @NoArgsConstructor @ToString @Builder @Data
public class Payment {

	@Id
	@Column (name="payment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPayment;

	@Column(nullable = false, name="reference")
	@NotNull(message = "La referencia del pago no puede ser vacia. ")
	private String reference;

	@Column(nullable = false, name="description")
	@NotNull(message = "La description del pago no puede ser vacia. ")
	private String description;

	@Column(nullable = false, name="currency")
	@NotNull(message = "Tipo de moneda no puede ser vacia. ")
	private String currency;

	@Column(nullable = false, name="total")
	@Positive(message="Total debe ser positivo")
	private double total;

	@Column(name="allowPartial")
	private boolean allowPartial;

	public Amount getAmount() {
		return new Amount(this.currency, this.total);
	}
}
