package com.altran.dgt.common.cdi;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

import com.altran.dgt.common.log.LogService;

public class LogProducer {

	@Produces
	@Default
	public LogService createLogService() {
		return LogService.getService();
	}


	@Produces
	@Logger
	public LogService createLoggerService() {
		return LogService.getService();
	}
}
