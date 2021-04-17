package com.crud;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.DTO.EditarProductoDto;
import com.crud.DTO.EliminarDto;
import com.crud.DTO.FacturaDto;
import com.crud.model.Pedido;
import com.crud.model.Producto;

/**
 * Clase Controlador
 * 
 * @author Danny Macias Vanegas
 *
 */
@RestController
public class Controller {

	ArrayList<Pedido> pedidosC = new ArrayList<>();

	/**
	 * Metodo que crea un nuevo pedido y se genera la nueva Factura
	 * 
	 * @param un objeto tipo Pedido
	 * @return se retorna un json con la factura
	 */
	@PostMapping("/pedido")
	public ResponseEntity pedido(@RequestBody Pedido pedido) {

		int suma = calcularProductos(pedido.getProductos());

		pedido.setIdFactura(new Date().getTime());

		pedido.setDomicilio(calcularDomicilio(suma));

		pedido.setTotal(suma + pedido.getDomicilio());

		pedido.setFechapedido(new Date());

		pedidosC.add(pedido);

		FacturaDto facturaDto = new FacturaDto();
		facturaDto.setIdFactura(pedido.getIdFactura());
		facturaDto.setTotal(pedido.getTotal());
		facturaDto.setValorDomicilio(pedido.getDomicilio());

		return ResponseEntity.ok(facturaDto);

	}

	
	/**
	 * Metodo que edita un pedido
	 * 
	 * @param un objeto tipo Editar producto, a partir de esta clase se obtienen los nuevos productos
	 * que se piensan agregar en la compra
	 * @return se retorna un json con el id de la factura, el valor la compra y del domicilio 
	 */
	@PutMapping(value = "/editarPedido")
	public ResponseEntity<FacturaDto> getPrestamoId(@RequestBody EditarProductoDto editarProducto) {

		Pedido pedidos = encontrarPedido(editarProducto.getIdFactura());

		if (pedidos == null) {

			return ResponseEntity.notFound().build();

		}

		if (calcularHoras(pedidos.getFechapedido()) > 5) {

			return ResponseEntity.badRequest().build();

		}

		int suma = calcularProductos(new ArrayList(editarProducto.getProductos()));

		int domicilio = calcularDomicilio(suma);

		if (suma + domicilio < pedidos.getTotal()) {

			return ResponseEntity.badRequest().build();

		}

		pedidos.setDomicilio(domicilio);

		pedidos.setTotal(suma + pedidos.getDomicilio());

		pedidos.setFechapedido(new Date());

		FacturaDto facturaDto = new FacturaDto();
		facturaDto.setIdFactura(pedidos.getIdFactura());
		facturaDto.setTotal(pedidos.getTotal());
		facturaDto.setValorDomicilio(pedidos.getDomicilio());

		return ResponseEntity.ok(facturaDto);

	}

	/**
	 * Metodo que elimina un pedido y se verifica si han pasado mas de las 12 horas
	 * desde que se genero la factura
	 * @param un objeto de la clase EliminarDto
	 * @return se retorna un json el valor que se debe cancelar si se paso de las 12 horas 
	 */
	@DeleteMapping(value = "/eliminarPedido")
	public ResponseEntity eliminarPedido(@RequestBody EliminarDto eliminar) {

		Pedido pedidos = encontrarPedido(eliminar.getIdFactura());

		int horas = calcularHoras(pedidos.getFechapedido());

		EliminarDto eliminarDto = new EliminarDto();

		int suma = calcularProductos(pedidos.getProductos());

		int valor = 0;
		if (horas > 12) {

			valor = (int) (suma * 0.10);
			eliminarDto.setValorFacturacion(valor);

			eliminar(pedidos.getIdPedido());

		}

		eliminar(pedidos.getIdPedido());

		return ResponseEntity.ok(eliminarDto);
	}

	/**
	 * Metodo que elimina un pedido
	 * 
	 * @param un idPedido
	 * @return se retorna un true en caso de que se haya eliminado
	 */
	public boolean eliminar(Long idPedido) {

		for (Pedido pedido : pedidosC) {

			if (pedido.getIdPedido().equals(idPedido)) {

				pedidosC.remove(pedido);
				return true;
			}

		}
		return false;

	}

	/**
	 * Metodo que calcula el valor de los productos
	 * 
	 * @param un ArrayList de producto
	 * @return se retorna la suma de los costos de cada producto
	 * incluyendo el iva del 19%
	 */
	public int calcularProductos(ArrayList<Producto> productos) {

		int suma = 0;
		for (int i = 0; i < productos.size(); i++) {

			suma += productos.get(i).getCosto();
		}

		return (int) (suma * 0.19);
	}

	/**
	 * Metodo que calcula el valor del domicilio
	 * a partir de la suma de los productos 
	 * @param la suma de los productos
	 * @return se retorna el valor del domicilio
	 */
	public int calcularDomicilio(int suma) {

		int valoDomicilio = 0;
		if (suma < 100000) {

			valoDomicilio = 10000;

		}

		return valoDomicilio;
	}

	/**
	 * Metodo que a partir del id encuentra el pedido
	 * 
	 * @param id de la Factura
	 * @return se retorna el pedido que se encontro
	 */
	public Pedido encontrarPedido(Long id) {

		for (Pedido pedido : pedidosC) {

			System.out.println(pedido.getIdFactura() + "id" + id);
			if (pedido.getIdFactura().equals(id)) {

				return pedido;
			}

		}
		return null;

	}
	
	/**
	 * Metodo que calcula las horas de diferencia
	 * 
	 * @param la fecha de cuando fue creado el pedido
	 * @return retorna las horas de diferencia entre ambas fechas
	 */
	public int calcularHoras(Date fecha) {

		Date ahora = new Date();

		int diferencia = (int) ((ahora.getTime() - fecha.getTime()) / 1000);

		int dia = 0;
		int hora = 0;
		int minuto = 0;
		if (diferencia > 86400) {
			dia = (int) Math.floor(diferencia / 86400);
			diferencia = diferencia - (dia * 86400);
		}
		if (diferencia > 3600) {
			hora = (int) Math.floor(diferencia / 3600);
			diferencia = diferencia - (hora * 3600);
		}
		if (diferencia > 60) {
			minuto = (int) Math.floor(diferencia / 60);
			diferencia = diferencia - (minuto * 60);
		}

		return hora;
	}

}
