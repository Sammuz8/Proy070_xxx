package com.curso.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.domain.Producto;

@Controller
public class ProductosController {

	@RequestMapping("/verprodu")
	public String saludar(Model model) {
		Producto produ= new Producto("1","jamon", new BigDecimal(50));
		produ.setCategoria("alimentacion");
		produ.setDescripcion("es un jamon");
		produ.setDisponible(true);
		produ.setFabricante("algun sitio de la tierra");
		produ.setUnidadesEnStock(99);
		
		model.addAttribute("producto", produ);
		return "productos";
	}
}
