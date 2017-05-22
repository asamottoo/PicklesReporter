/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.time;

/**
 *
 * @author t.asamoto
 */
public interface TimeInterface {
	
	/**
	 * フォーマットに従い現在日時を取得します。
	 * @return 変換された現在日時
	 */
	abstract public String now();
	
}
