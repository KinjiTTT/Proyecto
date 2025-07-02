package modelo;

import java.math.BigDecimal;

public class Recarga {

	private int codigo;
	private String numeroDeTelefono;
	private int companiaTelefonica;
	private BigDecimal montoRecarga;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNumeroDeTelefono() {
		return numeroDeTelefono;
	}
	public void setNumeroDeTelefono(String numeroDeTelefono) {
		this.numeroDeTelefono = numeroDeTelefono;
	}
	public int getCompaniaTelefonica() {
		return companiaTelefonica;
	}
	public void setCompaniaTelefonica(int companiaTelefonica) {
		this.companiaTelefonica = companiaTelefonica;
	}
	public BigDecimal getMontoRecarga() {
		return montoRecarga;
	}
	public void setMontoRecarga(BigDecimal montoRecarga) {
		this.montoRecarga = montoRecarga;
	}
	
}
