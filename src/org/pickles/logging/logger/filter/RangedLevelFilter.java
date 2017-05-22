/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.logger.filter;

/**
 * 指定した範囲のレベルの時にtrueを返すようなフィルターを返します。
 * @author t.asamoto
 */
public class RangedLevelFilter implements Filter {

	private int min;
	private int max;
	
	/**
	 * コンストラクタです。
	 * 引数にて範囲を設定します。fromとtoの大小関係は問いません。
	 * @param from
	 * @param to 
	 */
	public RangedLevelFilter(int from, int to){
		if(from <= to){
			min = from;
			max = to;
		}else{
			min = to;
			max = from;
		}
	}
	
	@Override
	public boolean canOutput(int level) {
		return min <= level && level <= max;
	}
}
