/**
 * 
 */
package com.canada.shawinigan.pos.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.canada.shawinigan.pos.events.ControllerEvent;

/**
 * @author mint
 *
 */

@RestController
public class SetReceiver {
	
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	@PostMapping(value="/api")
	public String getSet(@RequestBody Object object) {
		
		logger.info("Getting the set  .. . ");
		logger.info("object: {}", object.toString());
		
		ControllerEvent controllerEvent = new ControllerEvent(object);
		
		applicationEventPublisher.publishEvent(controllerEvent);
		
		return null;
		
	}

}
