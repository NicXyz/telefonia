package telefonia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="linea")
public class Linea {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_linea", nullable=true)
	private Integer codLinea;
			
    @Column(name="tipo")
    private String tipo;
	
    @Column(name="stato")
    private String stato;
    
    @Column(name="telefono")
    private String telefono;

	public Integer getCodLinea() {
		return codLinea;
	}
	public void setCodLinea(Integer codLinea) {
		this.codLinea = codLinea;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
