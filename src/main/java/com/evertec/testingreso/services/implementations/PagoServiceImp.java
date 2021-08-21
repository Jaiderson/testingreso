package com.evertec.testingreso.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evertec.testingreso.entities.Pago;
import com.evertec.testingreso.repositories.IPagoRep;
import com.evertec.testingreso.services.IPagoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagoServiceImp implements IPagoService{

	@Autowired
	private final IPagoRep pagoRep;

	@Override
	public Pago buscarPagoById(Long idPago) {
		return pagoRep.findByIdPago(idPago);
	}

	@Override
	public Pago crearPago(Pago pago) {
		Pago pagoDb = buscarPagoById(pago.getIdPago());
		if(null != pagoDb) {
			return pagoDb;
		}
		return pagoRep.save(pago);
	}

	@Override
	public Pago modificarPago(Pago pago) {
		Pago pagoDb = buscarPagoById(pago.getIdPago());
		if(null == pagoDb) {
			return crearPago(pago);
		}
		pago.setIdPago(pagoDb.getIdPago());
		return pagoRep.save(pago);
	}

	@Override
	public Pago eliminarPago(Long idPago) {
		Pago pagoDb = buscarPagoById(idPago);
		if(null == pagoDb) {
			return null;
		}
		pagoRep.delete(pagoDb);
		return pagoDb;
	}

	@Override
	public List<Pago> consultarPagos() {
		return pagoRep.findAll();
	}

}
