/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.logger;

/**
 *
 * @author t.asamoto
 */
public interface SimpleLoggerInterface {

	/**
	 * traceレベルのメッセージを出力します。
	 * @param message 
	 */
	abstract public void trace(String message);

	/**
	 * debugレベルのメッセージを出力します。
	 * @param message 
	 */
	abstract public void debug(String message);
	

	/**
	 * infoレベルのメッセージを出力します。
	 * @param message 
	 */
	abstract public void info(String message);

	/**
	 * noticeレベルのメッセージを出力します。
	 * @param message 
	 */
	abstract public void notice(String message);

	/**
	 * warnレベルのメッセージを出力します。
	 * @param message 
	 */
	abstract public void warn(String message);

	/**
	 * errorレベルのメッセージを出力します。
	 * @param message 
	 */
	abstract public void error(String message);

	/**
	 * fatalレベルのメッセージを出力します。
	 * @param message 
	 */
	abstract public void fatal(String message);

}