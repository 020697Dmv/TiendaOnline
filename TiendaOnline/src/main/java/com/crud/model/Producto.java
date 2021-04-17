package com.crud.model;

/**
 * Clase Producto
 * 
 * @author Danny Macias Vanegas
 *
 */
public class Producto {
	
	/**
	* Variable idProducto la cual es el identificador de un producto
	*/
	private int idProducto;
	
	/**
	* Variable costo la cual representa el costo de ese producto
	*/
	private int costo;

	/**
	* Setters y getters
	*/
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}


}
