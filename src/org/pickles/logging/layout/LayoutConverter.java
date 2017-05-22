/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.layout;

import java.util.HashMap;
import java.util.Set;
import org.pickles.logging.time.TimeGenerater;

/**
 *
 * @author t.asamoto
 */
public class LayoutConverter implements Layout {
	
	private String timeLayout = "MM-dd HH:mm:ss";
	private String layout = "";
	private HashMap<String, String> convertMap = new HashMap<>();
	private Set<String> keySet = null;
	private boolean isCompiled = false;
	private String compiledLayout = "%message%";
	private String sep = "%";
	
	private LayoutConverter(){
		convertMap.put("message", holdBetweenSeparator("message"));
		convertMap.put("time", holdBetweenSeparator("time"));
	}

	/**
	 * 変換対象となる文字列を出力する。
	 * @param key
	 * @param value 
	 */
	public void setConvertElement(String key, String value){
		convertMap.put(key, value);
	}
	
	/**
	 * 時間のレイアウトを設定する。
	 * @param timeLayout not null
	 */
	public void setTimeLayout(String timeLayout){
		this.timeLayout = timeLayout;
	}
	
	/**
	 * クラス名を設定する。
	 * @param className  not null
	 */
	public void setClassName(String className){
		convertMap.put("className", className);
		setKeySet();
	}
	
	/**
	 * メソッド名を設定する。
	 * @param methodName  not null
	 */
	public void setMethodName(String methodName){
		convertMap.put("methodName", methodName);
		setKeySet();
	}
	
	/**
	 * クラス名・メソッド名をStackTraceElementから取得する。
	 * @param ste  not null
	 */
	public void setInfoFromStackTraceElement(StackTraceElement ste){
		convertMap.put("className", ste.getClassName());
		convertMap.put("methodName", ste.getMethodName());
		setKeySet();
	}
	
	@Override
	public String convert(String message){
		if(!isCompiled) compileLayout();
		String[] splitted = compiledLayout.split("%");
		for(int index = 1; index < splitted.length/2; index+=2){
			if(splitted[index].equals("message"))splitted[index] = message;
			if(splitted[index].equals("time"))splitted[index] = getTime();
		}
		return integrate(splitted);
	}
	
	@Override
	public void setLayout(String layout) {
		this.layout = layout;
	}

	@Override
	public void setSeparator(String sep) {
		this.sep = sep;
	}

	/**
	 * レイアウトのうち、時間とメッセージ以外の情報を記述した文字列を作成します。
	 */
	private void compileLayout(){
		String[] splitted = layout.split(sep);
		for(int index = 1; index < splitted.length/2; index+=2){
			for(String key: keySet) {
				if(key.equals(splitted[index])){
					splitted[index] = convertMap.get(key);
				}
			}
		}
		isCompiled = true;
	}
	
	/**
	 * 置換対象のキーセットを設定します。
	 */
	private void setKeySet(){
		keySet = convertMap.keySet();
	}

	/**
	 * 文字列の配列を結合します。
	 * @param array 結合対象の文字配列
	 * @return 結合した文字列
	 */
	private String integrate(String[] array){
		StringBuilder sb = new StringBuilder();
		for(String str : array)sb.append(str);
		return sb.toString();
	}

	/**
	 * 時間の文字列を取得する。
	 * @return 現在の時間
	 */
	private String getTime(){
		TimeGenerater tg = TimeGenerater.getInstance(timeLayout);
		return tg.now();
	}

	/**
	 * 入力したタグの両端に区切り文字を入力する。
	 * @param tag
	 * @return 
	 */
	private String holdBetweenSeparator(String tag){
		return new StringBuilder(sep).append(tag).append(sep).toString();
	}
}
