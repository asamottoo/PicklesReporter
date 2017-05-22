/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.util.printer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author t.asamoto
 */
public class ValuePrinter extends Printer {
	
	private static String indent  = "    ";
	private static String childIndent = "  |-";
	private static String valueHeaderPattern = "~~~~ %valueName% ~~~~";
	private static String collectionIndent = "|=";
	
	/**
	 * 引数に入力したオブジェクト内部を解析し、ログ出力用の文字列配列に変換する。
	 * @param valueName -  解析対象の変数名
	 * @param value - 解析対象()
	 * @return 
	 */
	public static String[] getConvertObjectToLog(String valueName,Object value){
		ArrayList<String> strList = new ArrayList<>();
		List<Field> fieldList = Arrays.asList(value.getClass().getDeclaredFields());
		
		//解析
		
		
		
		return (String[]) strList.toArray();
	}
	
	private static String analizeStandardType(Field field){
		return null;
	}
	
	private static List<String> analizeClass(Field field){
		return null;		
	}
	
	private static boolean isStandardType(){
		return false;
	}
	
	private static String[] getFieldNames(){
		return null;
	}

	@Override
	protected String buildMessage() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
