package com.crud.DTO;

/**
 * Clase FacturaDto 
 * Esta clase es utilizada para el ENDPOINT donde se calcula
 * el valor del domicilio
 * @author Danny Macias Vanegas
 *
 */
public class FacturaDto {
	
	
	
	/**
	* Variable idFactura la cual representa el identificador de la Factura
	*/
	private Long idFactura;
	
	/**
	* Variable valorDomicilio la cual representa el valor del domicilio
	*/
	private int valorDomicilio;
	
	/**
	* Variable total la cual representa el valor total a pagar
	*/
	private int total;


	/**
	* Setters y getters
	*/
	public Long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	public int getValorDomicilio() {
		return valorDomicilio;
	}

	public void setValorDomicilio(int valorDomicilio) {
		this.valorDomicilio = valorDomicilio;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	

}
