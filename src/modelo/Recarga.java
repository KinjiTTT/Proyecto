package modelo;

import java.math.BigDecimal;

public class Recarga {

	private int codigo;
	private String companiaTelefonica;
	private String numeroDeTelefono;
	private BigDecimal montoRecarga;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getCompaniaTelefonica() {
		return companiaTelefonica;
	}
	public void setCompaniaTelefonica(String companiaTelefonica) {
		this.companiaTelefonica = companiaTelefonica;
	}
	
	public String getNumeroDeTelefono() {
		return numeroDeTelefono;
	}
	public void setNumeroDeTelefono(String numeroDeTelefono) {
		this.numeroDeTelefono = numeroDeTelefono;
	}
	
	public BigDecimal getMontoRecarga() {
		return montoRecarga;
	}
	public void setMontoRecarga(BigDecimal montoRecarga) {
		this.montoRecarga = montoRecarga;
	}
	
}
