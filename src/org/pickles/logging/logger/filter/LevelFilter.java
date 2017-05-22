/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.logger.filter;

import org.pickles.logging.LoggerConst;
import org.pickles.logging.logger.Logger;

/**
 * 設定したレベル以上の場合にtrueを返すフィルターです。
 * @author t.asamoto
 */
public class LevelFilter implements Filter {

	private int threshold;
	
	public LevelFilter(int level){
		threshold = level;
	}

	@Override
	public boolean canOutput(int level) {
		return threshold <= level;
	}

	
	 
}
