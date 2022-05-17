package com.sia.taco.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sia.taco.entities.Order;
import com.sia.taco.entities.Taco;
import com.sia.taco.repositories.OrderRepository;


@RestController
@RequestMapping(path = "/orders", produces = "application/json")
public class OrderController {
	OrderRepository orderRepo;
	
	@Autowired
	EntityLinks entityLinks;
	public OrderController(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}

	@GetMapping("/recent")
	public List<Order> recentTaco() {
		return orderRepo.findAll();
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Order postOrder(@RequestBody Order order) {
		return orderRepo.save(order);
	}
}
