package com.uniritter.monitor.domain.alertas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class Notificacao {

	static Logger log_init;
	
	public static Logger log(Object a){		
						
		return log_init = LoggerFactory.getLogger(a.toString());
	}
	
}
