package com.mwiesner.sp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mwiesner.myorder.Order;

@Controller
public class OrderRestController {
	
	@RequestMapping(value="/order/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Order getOrder(@PathVariable("id") String id) {
		System.out.println("TEST");
		Order order = new Order();
		order.setCustomer("Mike");
		order.setName(id);
		return order;
	}

}
