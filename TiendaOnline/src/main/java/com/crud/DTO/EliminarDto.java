package com.crud.DTO;

/**
 * Clase EliminarDto 
 * Esta clase es utilizada para el ENDPOINT que solicita eliminar un Pedido
 * @author Danny Macias Vanegas
 *
 */
public class EliminarDto {

	/**
	* Variable idPedido la cual es el identificador de un pedido
	*/
	private Long idPedido;
	
	/**
	* Variable idFactura la cual representa el identificador de la Factura
	*/
	private Long idFactura;
	
	/**
	* Variable valorFacturacion la cual almacena el valor que debe pagar el cliente
	* en caso de haber solicitado la cancelacion despues de 12 horas
	*/
	private int valorFacturacion;

	/**
	* Setters y getters
	*/
	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public int getValorFacturacion() {
		return valorFacturacion;
	}

	public void setValorFacturacion(int valorFacturacion) {
		this.valorFacturacion = valorFacturacion;
	}

	public Long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	
}
