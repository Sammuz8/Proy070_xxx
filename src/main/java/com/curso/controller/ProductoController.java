package com.curso.controller;

import com.curso.domain.Producto;
import com.curso.excepcion.GestionProductoException;
import com.curso.service.ProductoService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("comercio")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	public ProductoController() {
		System.out.println("...Iniciando ProductoController");
	}

	@RequestMapping("/productos")
	public String list(Model model) {

		model.addAttribute("productos", productoService.getTodosProductos());

		return "productos";
	}
	@RequestMapping("/productos/{categoria}")
	public String getProductosPorCategoria(Model model, @PathVariable("categoria") String categoriaProducto) {

		model.addAttribute("productos", productoService.getProductosPorCategoria(categoriaProducto));
		return "productos";
	}
	
	
	//meustra el producto por id pasandole el id como parametro ?id=xxx
	@RequestMapping("/producto")
	// @RequestMapping(method = RequestMethod.GET, path = "/producto")
	// @GetMapping("/producto")
	public String getProductoPorId(@RequestParam("id") String productId, Model model) {
		model.addAttribute("producto", productoService.getProductoPorId(productId));
		return ("producto");
	}
	//meustra el producto por id pasandole el id desde path 
	@RequestMapping("/producto/id/{idProdu}")
	public String getProductoPorPathId(Model model, @PathVariable("idProdu") String idProducto) {
		model.addAttribute("producto", productoService.getProductoPorId(idProducto));
		return ("producto");
	}
	
	
	// mostra el fomulario    
	//method = RequestMethod.GET
	@GetMapping(value = "/productos/nuevo")
	public String getCrearNuevoProductoFormulario(Model model) {
		Producto nuevoProducto = new Producto();
		nuevoProducto.setDescripcion("nuevo");
		model.addAttribute("nuevoProducto", nuevoProducto);
		return "crear-producto";
	}

	@RequestMapping(value = "/productos/nuevo", method = RequestMethod.POST)
	public String procesarCrearNuevoProductoFormulario(
			@ModelAttribute("nuevoProducto") 
			@Valid Producto nuevoProducto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			//nuevoProducto.setDescripcion("error");
			return "crear-producto";//no usar redirect: que se pierde el error
		}
		productoService.crearProducto(nuevoProducto);
// model.addAttribute("productos",
// productoService.getTodosProductos());
// return "productos";
		return "redirect:/comercio/productos";
	}
	
//  href="producto/edit?id" + ${producto.idProducto}
	// mostra el fomulario
		@GetMapping(value = "/producto/edit")
		public String getModifProductoFormulario(
				@RequestParam("id") String productId,
				Model model) {
			Producto prodModif =   productoService.getProductoPorId(productId);

			if(prodModif == null) {
				throw new GestionProductoException(productId,"El producto no existe");
			}
			
			model.addAttribute("productoModif", prodModif);
			return "modif-producto";
		}

		@GetMapping(value = "/producto/delete")
		public String borrarProducto(
				@RequestParam("id") String productId) {
		
			productoService.borrar(productId);
			return "redirect:/comercio/productos"; 
		}
		
		
		// tratara los datos recibidos del formulario
		@PostMapping(value = "/producto/edit")
		public String procesarModificarProductoFormulario(
				@ModelAttribute("productoModif") @Valid Producto productoModif,
				BindingResult bindingResult) {
			
			//comprobar que es valido 
			if (bindingResult.hasErrors()) {
				return "modif-producto";  
			}

			productoService.modificar(productoModif);
			return "redirect:/comercio/productos"; 
		}
		

	@ExceptionHandler(GestionProductoException.class)
	public ModelAndView handleError(HttpServletRequest req, GestionProductoException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("idProductoNoEncontrado", exception.getIdProducto());
		mav.addObject("claveMensage", exception.getClaveMensaje());
		mav.setViewName("producto-exception");
		return mav;
	}

}
