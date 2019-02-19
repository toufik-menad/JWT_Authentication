/**
 * 
 */
package com.canada.shawinigan.pos.events;

import org.springframework.context.ApplicationEvent;

/**
 * @author mint
 *
 */
public class ControllerEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */private Object source;


	public ControllerEvent(Object source) {
		super(source);
		this.source=source;
	}


	public Object getSource() {
		return source;
	}


	public void setSource(Object source) {
		this.source = source;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
