package com.crud.DTO;

import java.util.List;

import com.crud.model.Producto;

/**
 * Clase EditarProductoDto 
 * Esta clase es utilizada para el ENDPOINT que solicita editar un producto 
 * @author Danny Macias Vanegas
 *
 */
public class EditarProductoDto {

	/**
	* ArrayList con todos los nuevos productos que se desean agregar
	*/
	private List<Producto> productos;
	
	/**
	* Variable idFactura la cual representa el identificador de la Factura
	*/
	private Long idFactura;

	
	/**
	* Setters y getters
	*/
	public Long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}


}
