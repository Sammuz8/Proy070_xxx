package com.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.service.PedidoService;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	public PedidoController() {
		// TODO Auto-generated constructor stub
		System.out.println(".....Iniciando pedido controller");
	}

//	@GetMapping("/P1234/2")
//	public String hacerPedido(Model model) {
//		
//		pedidoService.generarPedido("P1234", 2);
//		
//		//return "productos" //WEB-INF/jsp/productos.jsp
//		return "redirect:/comercio/productos";
//
//	}
	
	@GetMapping("/{idProducto}/{cantidad}")
	public String process(
			@PathVariable ("idProducto")String idProducto,
			@PathVariable ("cantidad") String cantidades
			) {
		int cantidad = Integer.parseInt(cantidades);
    	System.out.println("...... pidiendo " + idProducto  + " cantidad " + cantidades);
    	pedidoService.generarPedido(idProducto, cantidad);		
		//return "productos" //WEB-INF/jsp/productos.jsp
		return "redirect:/comercio/productos";

	}
}
