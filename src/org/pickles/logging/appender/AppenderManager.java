/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.appender;

import java.util.HashMap;

/**
 * ライブラリ内のAppenderインスタンスの生成管理を行います。
 * @author t.asamoto
 */
public class AppenderManager {


	////////////////////////////////////
	//  StandardAppender管理セクション  //
	///////////////////////////////////

	//System.outに対する出力を管理する。
	private static Appender stdout = new StandardOutAppender();
	
	//System.errに対する出力を管理する。
	private static Appender stderr = new StandardErrAppender();

	/**
	 * Sytem.outに対する出力を管理するアペンダーを返す。
	 * @return 
	 */
	public static Appender getStandardOutAppender(){
		return stdout;
	}
	
	/**
	 * Sytem.errに対する出力を管理するアペンダーを返す。
	 * @return 
	 */
	public static Appender getStandardErrAppender(){
		return stderr;
	}
	
	
	
	////////////////////////////////
	//  FileAppender管理セクション  //
	///////////////////////////////
	private static HashMap<String, Appender> fileAppenderMap = new HashMap<>();

	public static Appender getFileAppender(String fileName){
		if(fileAppenderMap.containsKey(fileName)) generateFileAppender(fileName);
		return fileAppenderMap.get(fileName);
	}
	
	synchronized public static void generateFileAppender(String fileName){
		if(fileAppenderMap.containsKey(fileName)){
			fileAppenderMap.put(fileName, new FileAppender(fileName));
		}
	}
	
}
