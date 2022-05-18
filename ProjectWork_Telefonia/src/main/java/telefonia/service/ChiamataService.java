package telefonia.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telefonia.db.ChiamataRepository;
import telefonia.model.Chiamata;

@Service
public class ChiamataService {

	@Autowired
	ChiamataRepository chiamateRepository;

	public Chiamata inserisciChiamata(Chiamata c) {
		c.setDurata(c.calcoloDurata());

		return chiamateRepository.save(c);
	}

	public Chiamata aggiornaChiamata(Integer id, Chiamata c) {
		Chiamata chiamataDaAggiornare = chiamateRepository.findByCodChiamata(id);
		
		chiamataDaAggiornare.setCodLineaChiamante(c.getCodLineaChiamante());
		chiamataDaAggiornare.setCodLineaChiamato(c.getCodLineaChiamato());
		chiamataDaAggiornare.setDataInizio(c.getDataInizio());
		chiamataDaAggiornare.setDataFine(c.getDataFine());
		chiamataDaAggiornare.setDurata(c.calcoloDurata());

		return chiamateRepository.save(chiamataDaAggiornare);
	}
	
	public Chiamata eliminaChiamata(Integer id) {
		return chiamateRepository.deleteByCodChiamata(id);
	}
	
	public Long calcoloDurataChiamata(Integer id, Date dateStart, Date dateEnd) {
		
		
		return chiamateRepository.sommaDurate(id, dateStart, dateEnd);
	}

}