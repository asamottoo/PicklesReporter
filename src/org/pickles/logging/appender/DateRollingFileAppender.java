/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.appender;

/**
 *
 * @author t.asamoto
 */
public class DateRollingFileAppender extends RollingFileAppender {

	private String rollingTime = null;
	
	public DateRollingFileAppender(AbstractFileAppender fileAppender, String rollingTime) {
		super(fileAppender);
		this.rollingTime = rollingTime;
	}

	public DateRollingFileAppender(AbstractFileAppender fileAppender) {
		super(fileAppender);
		this.rollingTime = "03:00";
	}
	
	@Override
	public boolean isRollingTarget() {
		return false;
		//後で書く。
	}
	
}
