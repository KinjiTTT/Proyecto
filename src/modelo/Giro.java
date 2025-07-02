package modelo;

import java.math.BigDecimal;

public class Giro {

	int codigo;
	String operacion;
	String numeroDestino;
	String numeroRemitente;
	String cedulaRemitente;
	BigDecimal montoGiro;
	String metodoPago;
	String codigoSeguridad;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public String getNumeroDestino() {
		return numeroDestino;
	}
	public void setNumeroDestino(String numeroDestino) {
		this.numeroDestino = numeroDestino;
	}
	public String getNumeroRemitente() {
		return numeroRemitente;
	}
	public void setNumeroRemitente(String numeroRemitente) {
		this.numeroRemitente = numeroRemitente;
	}
	public String getCedulaRemitente() {
		return cedulaRemitente;
	}
	public void setCedulaRemitente(String cedulaRemitente) {
		this.cedulaRemitente = cedulaRemitente;
	}
	public BigDecimal getMontoGiro() {
		return montoGiro;
	}
	public void setMontoGiro(BigDecimal montoGiro) {
		this.montoGiro = montoGiro;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public String getCodigoSeguridad() {
		return codigoSeguridad;
	}
	public void setCodigoSeguridad(String codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}
	
	
	
}
