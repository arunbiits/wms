/**
 * 
 */
package io.arun.learning.camel.wms.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.arun.learning.camel.wms.model.WareHouseOrder;

/**
 * @author arun
 *
 */
@RestController
@RequestMapping("/api/v1")
public class WmsController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/status/{name}")
	public String test(@PathVariable String name) {
		return "Hi "+name+"! WMS Server is up and running";
	}
	
	@PostMapping("/orders")
	public ResponseEntity<Object> getOrders(@RequestBody WareHouseOrder[] wareHouseOrders) {
		if(wareHouseOrders.length == 0) {
			logger.info("Orders not valid");
			return new ResponseEntity<Object>("No orders found in the given json input", HttpStatus.BAD_REQUEST);
		}else {
			System.out.println(Arrays.asList(wareHouseOrders));
			return new ResponseEntity<Object>("Orders successfully added to WMS",HttpStatus.OK);
		}
	}
	
}
