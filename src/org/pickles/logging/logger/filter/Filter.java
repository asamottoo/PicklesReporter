/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.logger.filter;

/**
 *
 * @author t.asamoto
 */
public interface Filter {
	
	/**
	 * 出力できるかどうかを返します。
	 * @param level
	 * @return 
	 */
	abstract public boolean canOutput(int level);
	
}
