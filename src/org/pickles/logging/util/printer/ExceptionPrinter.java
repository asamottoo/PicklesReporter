/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.util.printer;

/**
 *
 * @author t.asamoto
 */
public interface ExceptionPrinter {
	
	/**
	 * 例外の内容をロガーに出力します。
	 */
	abstract public void printExceptionMessage();
	
	/**
	 * スタックトレースをロガーに出力します。
	 */
	abstract public void printStackTrace();
	
	
}
