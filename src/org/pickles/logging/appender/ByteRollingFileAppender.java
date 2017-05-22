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
public class ByteRollingFileAppender extends RollingFileAppender {

	
	private long byteSize = 100000000l;
	
	public ByteRollingFileAppender(AbstractFileAppender fileAppender) {
		super(fileAppender);
	}

	public ByteRollingFileAppender(AbstractFileAppender fileAppender, long byteSize) {
		super(fileAppender);
		this.byteSize = byteSize;
	}
	
	@Override
	protected boolean isRollingTarget() {
		return false;
		//後で書く。
	}
	
}
