package tacos.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient;
import tacos.Order;
import tacos.Taco;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

	private RestTemplate rest = new RestTemplate();

	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("order", new Order());
		return "orderForm";
	}

	@PostMapping
	public String processOrder(@RequestBody Order order, @RequestParam("tacos") String tacoIds) {
		List<Taco> tacos = new ArrayList<>();
		for(String tacoId : tacoIds.split(",")) {
			Taco taco = rest.getForObject("http://localhost:8080/design/{id}", Taco.class, tacoId);
			tacos.add(taco);
		}
		order.setTacos(tacos);
		rest.postForObject("http://localhost:8080/orders", order, Order.class);
		log.info("Order submitted: " + order);
		return "redirect:/";
	}
}
