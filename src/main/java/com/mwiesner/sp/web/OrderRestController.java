package com.mwiesner.sp.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.xml.transform.StringSource;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.mwiesner.myorder.Order;

@Controller
public class OrderRestController {
	
	
	private Order order;
	
	@Autowired
	private Jaxb2Marshaller marshaller;
	
	
	public OrderRestController() {
		this.order = new Order();
		this.order.setCustomer("Mike");
		this.order.setName("abc");
	}

	@RequestMapping(value="/order/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Order getOrder(@PathVariable("id") String id) {
		return this.order;
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value="/order/{id}", method=RequestMethod.PUT)
	public void updateOrder(@PathVariable("id") String id, @RequestBody byte[] body)  throws ParserConfigurationException, SAXException, IOException  {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(true);
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document xml = documentBuilder.parse(new ByteArrayInputStream(body));
		Order order = (Order) marshaller.unmarshal(new DOMSource(xml));		
		this.order = order;
	}

	
	
	
}
