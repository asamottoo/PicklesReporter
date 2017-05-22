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
abstract public class RollingFileAppender implements Appender {
	
	private AbstractFileAppender parentAppender = null;
	
	private String rolledName = "%fileName%-%dateTime%";
	private String dateTimeLayout = "";
	
	/**
	 * コンストラクタ。引数に入力したFileAppenderにRolling機能を付与します。
	 * @param fileAppender
	 */
	public RollingFileAppender(AbstractFileAppender fileAppender){
		this.parentAppender = fileAppender;
	}
	
	
	@Override
	public void output(String message) {
		parentAppender.output(message);
	}
	
	private void roll(){
		if(isRollingTarget()){
			//TODO write rolling;
		}
	}
	
	abstract protected boolean isRollingTarget();
	
	
}
