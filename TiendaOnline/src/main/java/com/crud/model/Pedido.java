package com.crud.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase Pedido
 * 
 * @author Danny Macias Vanegas
 *
 */
public class Pedido {

	/**
	* Variable idPedido la cual es el identificador de un pedido
	*/
	private Long idPedido;
	
	/**
	* Variable direccion del cliente	 
	*/
	private String direccion;
	
	/**
	* Variable idUsuario la cual es el identificador de un usuario
	*/
	private int idUsuario;
	
	/**
	* Variable fechapedido la cual representa la fecha en que se solicito el pedido
	*/
	private Date fechapedido;
	
	/**
	* Variable idFactura la cual representa el identificador de la Factura
	*/
	private Long idFactura;
	
	/**
	* Variable domicilio del pedido
	*/
	private int domicilio;
	
	/**
	* Variable total la cual representa el valor total que se debe pagar
	*/
	private int total;
	
	/**
	* ArrayList con todos los productos asociados al pedido
	*/
	private ArrayList <Producto> productos;

	/**
	* Contructor de la clase
	*/
	public Pedido(Long idPedido, String direccion, int idUsuario, Date fechapedido, Long idFactura, int domicilio,
			int total, ArrayList<Producto> productos) {
		super();
		this.idPedido = idPedido;
		this.direccion = direccion;
		this.idUsuario = idUsuario;
		this.fechapedido = fechapedido;
		this.idFactura = idFactura;
		this.domicilio = domicilio;
		this.total = total;
		this.productos = productos;
	}
	
	

	public Pedido() {
		super();
	}


	/**
	* Setters y getters
	*/
	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getFechapedido() {
		return fechapedido;
	}

	public void setFechapedido(Date fechapedido) {
		this.fechapedido = fechapedido;
	}

	public Long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	public int getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(int domicilio) {
		this.domicilio = domicilio;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	

	
}
