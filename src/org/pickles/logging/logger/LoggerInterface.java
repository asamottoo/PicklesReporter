/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.logger;

import java.util.List;
import org.pickles.logging.appender.Appender;
import org.pickles.logging.layout.Layout;
import org.pickles.logging.logger.filter.Filter;

/**
 *
 * @author t.asamoto
 */
public interface LoggerInterface {

	/**
	 * 1行分のログ出力を行います。
	 * @param level
	 * @param message 
	 */
	abstract public void output(int level, String message);

	/**
	 * 配列の要素1つにつき1行のログ出力を行います。<br>
	 * 出力はインデックスの小さい順に出力されます。
	 * @param level
	 * @param messages 
	 */
	abstract public void outputAll(int level, String[] messages);

	/**
	 * リストの要素1つにつき1行のログ出力を行います。<br>
	 * 出力はインデックスの小さい順に出力されます。
	 * @param level
	 * @param messages 
	 */
	abstract public void outputAll(int level, List<String> messages);
	
	/**
	 * レイアウトを設定します。
	 * @param layout 
	 */
	abstract public void setLayout(Layout layout);

	/**
	 * 出力先を設定します。
	 * @param appender 
	 */
	abstract public void setAppender(Appender appender);
	
	/**
	 * フィルターを設定します。
	 * @param filter 
	 */
	abstract public void setFilter(Filter filter);
}
