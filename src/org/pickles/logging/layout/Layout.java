/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.layout;

/**
 *
 * @author t.asamoto
 */
public interface Layout {

	/**
	 * 現在設定されているレイアウト情報を返します。
	 * @param layout
	*/
	abstract void setLayout(String layout);
	
	/**
	 * 分割文字を設定します。
	 * @param sep 
	 */
	abstract void setSeparator(String sep);
	
	/**
	 * 入力したメッセージをレイアウトに従って変換します。
	 * @param message
	 * @return 
	 */
	abstract String convert(String message);
	

	
	
}
