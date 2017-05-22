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
public class MemoryPrinter extends Printer {

	/**
	 * インスタンスを返します。
	 * @param logger
	 * @param level
	 * @return 
	 */
	public static MemoryPrinter getInstance(Logger logger, int level){
		MemoryPrinter mp = new MemoryPrinter();
		mp.setLevel(level);
		mp.setLogger(logger);
		return mp;
	}
	
	@Override
	protected String buildMessage() {
        long total = Runtime.getRuntime().totalMemory() / 1024;
        long free = Runtime.getRuntime().freeMemory() / 1024;
        long used = total - free;
		return new StringBuilder("Mem [ total:").append(String.valueOf(total))
				.append("KB, free: ").append(String.valueOf(free))
				.append("KB, used: ").append(String.valueOf(used))
				.append(" ]").toString();
	}

	
}
