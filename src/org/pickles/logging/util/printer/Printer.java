/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.util.printer;

import org.pickles.logging.logger.Logger;

/**
 *
 * @author t.asamoto
 */
abstract public class Printer {
	
	protected Logger logger = null;
	protected int level;
	
	/**
	 * 出力先ロガーを設定します。
	 * @param logger
	 */
	public void setLogger(Logger logger){
		this.logger = logger;
	}
	
	/**
	 * 出力レベルを設定します。
	 * @param level 
	 */
	public void setLevel(int level){
		this.level = level;
	}
	
	/**
	 * 印刷対象となる文字列を返します。
	 */
	abstract protected String buildMessage();

	/**
	 * メッセージを出力します。
	 */
	public void print(){
		logger.output(level, buildMessage());
	}
	
	
}
