package telefonia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="chiamata")
public class Chiamata {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_chiamata", nullable=true)
	private Integer codChiamata;
	
	@Column(name="cod_linea_chiamante")
	private Integer codLineaChiamante;
	
	@Column(name="cod_linea_chiamato")
	private Integer codLineaChiamato;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	@Column(name = "data_inizio")
	private Date dataInizio;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	@Column(name = "data_fine")
	private Date dataFine;
	
	@Column(name = "durata")
	private Long durata;
		
	public Long calcoloDurata() {
		
		return (this.dataFine.getTime() - this.dataInizio.getTime())/1000;
		        
	}
	
	public Integer getCodChiamata() {
		return codChiamata;
	}
	public void setCodChiamata(Integer codChiamata) {
		this.codChiamata = codChiamata;
	}
	public Integer getCodLineaChiamante() {
		return codLineaChiamante;
	}
	public void setCodLineaChiamante(Integer codLineaChiamante) {
		this.codLineaChiamante = codLineaChiamante;
	}
	public Integer getCodLineaChiamato() {
		return codLineaChiamato;
	}
	public void setCodLineaChiamato(Integer codLineaChiamato) {
		this.codLineaChiamato = codLineaChiamato;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public Long getDurata() {
		return durata;
	}
	public void setDurata(Long durata) {
		this.durata = durata;
	}
	
}
