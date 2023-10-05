package org.java.app.mvc.controller;

import java.util.List;

import org.java.app.db.pizza.Pizza;
import org.java.app.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/pizze")
public class PizzaController {

	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public String getIndex(Model model,
							@RequestParam(required = false) String research) {
		
//		System.out.println("Research:" + research);
		
		List<Pizza> pizze = research == null
					? pizzaService.findAll()
					: pizzaService.findByNameOrDescriptionContaining(research, research);	
		model.addAttribute("pizze", pizze);
		
		
		return "pizza-index";
	}
	
	@GetMapping("/{id}")
	public String getShow(@PathVariable int id, Model model) {
		
		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);
		
		return "pizza-show";
	}
	
	
}
