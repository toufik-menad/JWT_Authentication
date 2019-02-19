/**
 * 
 */
package com.canada.shawinigan.pos.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author mint
 *
 */
@Component
public class ControllerEventListener implements ApplicationListener<ControllerEvent>{
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	 

	@Override
	public void onApplicationEvent(ControllerEvent event) {
		// TODO Auto-generated method stub
		logger.info("Event captured . . . ");
	
		
	}

}
