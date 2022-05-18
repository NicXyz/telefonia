package telefonia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_cliente", nullable=true)
	private Integer codCliente;
	
    @Size(min=3, max=20, message="minimo 3/massimo 20 caratteri")
    @Column(name="nome")
    private String nome;
	
    @Size(min=3, max=20, message="minimo 3/massimo 20 caratteri")
    @Column(name="cognome")
    private String cognome;
    
    @Size(max=16, message="il cf è composto da 16 caratteri")
    @Column(name="cf")
    private String cf;
    
    @Column(name="cod_linea")
	private Integer codLinea;

	public Integer getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public Integer getCodLinea() {
		return codLinea;
	}
	public void setCodLinea(Integer codLinea) {
		this.codLinea = codLinea;
	}
	
	@Override
	public String toString() {
		return "Cliente [codCliente=" + codCliente + ", nome=" + nome + ", cognome=" + cognome + ", cf=" + cf
				+ ", codLinea=" + codLinea + "]";
	}
    
}
