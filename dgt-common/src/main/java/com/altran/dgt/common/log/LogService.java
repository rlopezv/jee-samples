/**
 *
 */
package com.altran.dgt.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ramon
 *
 */
public class LogService {

	private static LogService service;

	Logger logger = null;

	private LogService() {
		logger = LoggerFactory.getLogger("jee.dgt");

	}

	public static LogService getService() {
		if (null == service) {
			service = new LogService();
		}
		return service;
	}

	public void info(String message, Object ...parms) {
		logger.info(message, parms);
	}

}
