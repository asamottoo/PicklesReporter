/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 *
 * @author t.asamoto
 */
public class TimeGenerater
		implements TimeInterface{
	
	private static HashMap<String, TimeGenerater> instanceManager = new HashMap<>();
	
	/**
	 * 指定したフォーマットの時間情報を出力するインスタンスを生成する。
	 * @param format
	 * @return 
	 */
	public static TimeGenerater getInstance(String format){
		if(instanceManager.containsKey(format)) generateInstance(format);
		return instanceManager.get(format);
	}

	synchronized private static void generateInstance(String format){
		if(instanceManager.containsKey(format)){
			instanceManager.put(format, new TimeGenerater(format));
		}
	}

	private TimeGenerater(String format){
		dtf = DateTimeFormatter.ofPattern(format);
	}
	
	DateTimeFormatter dtf = null;

	@Override
	public String now() {
		LocalDateTime ldt = LocalDateTime.now();
		ldt.format(dtf);
		return ldt.toString();
	}
	
}
