/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.util.printer;

import org.pickles.logging.util.printer.Printer;
import org.pickles.logging.logger.Logger;

/**
 *
 * @author t.asamoto
 */
public class TimePrinter extends Printer {
	
	private long start = 0l;
	private int scale = 1000;
	private String unit = "us";
	
	/**
	 * インスタンスを返します。
	 * @param logger
	 * @param level
	 * @return 
	 */
	public static TimePrinter getInstance(Logger logger, int level){
		TimePrinter timer = new TimePrinter();
		timer.setLevel(level);
		timer.setLogger(logger);
		return timer;
	}
	
	/**
	 * 単位をmsで出力する。
	 */
	public void useMilliSecond(){
		this.scale = 1000000;
		this.unit = "ms";
		
	}

	/**
	 * 単位をusで出力する。
	 */
	public void useMicroSecond(){
		this.scale = 1000;
		this.unit = "us";
	}

	/**
	 * 単位をnsで出力する。
	 */
	public void useNanoSecond(){
		this.scale = 1;
		this.unit = "ns";
	}

	/**
	 * 時間の計測を開始する。
	 */
	public void start(){
		this.start = System.nanoTime();
	}
	
	@Override
	protected String buildMessage(){
		return ("time : " + String.valueOf((System.nanoTime() - start) / scale) + unit);
	}	

}
