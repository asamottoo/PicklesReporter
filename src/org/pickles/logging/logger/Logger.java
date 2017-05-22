/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.logger;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import org.pickles.logging.LoggerConst;
import org.pickles.logging.appender.Appender;
import org.pickles.logging.layout.Layout;
import org.pickles.logging.logger.controller.Controller;
import org.pickles.logging.logger.filter.Filter;

/**
 * ロガーの基本的な機能を定義します。
 * @author t.asamoto
 */
public abstract class Logger implements LoggerInterface, SimpleLoggerInterface{
	
	private Layout layout = null;
	private Appender appender = null;
	private Filter filter = null;
	private final Queue<String> messageQueue = new ArrayDeque<>();
	private Thread executor = null;
	private Controller controller;
	
	@Override
	public void trace(String message){
		output(LoggerConst.TRACE, message);
	}

	@Override
	public void debug(String message){
		output(LoggerConst.DEBUG, message);
	}
	
	@Override
	public void info(String message){
		output(LoggerConst.INFO, message);
	}

	@Override
	public void notice(String message){
		output(LoggerConst.NOTICE, message);
	}

	@Override
	public void warn(String message){
		output(LoggerConst.WARN, message);
	}

	@Override
	public void error(String message){
		output(LoggerConst.ERROR, message);
	}

	@Override
	public void fatal(String message){
		output(LoggerConst.FATAL, message);
	}

	@Override
	public void output(int level, String message){
		if(filter.canOutput(level)){
			messageQueue.offer(message);
			start();
		}
	}
	
	@Override
	public void outputAll(int level, String[] messages){
		if(filter.canOutput(level)){
			for(String message : messages){
				appender.output(message);
			}
			start();
		}
	}

	@Override
	public void outputAll(int level, List<String> messages){
		if(filter.canOutput(level)){
			for(String message : messages){
				appender.output(message);
			}
			start();
		}
	}
	
	@Override
	public void setLayout(Layout layout){
		this.layout = layout;
	}

	@Override
	public void setAppender(Appender appender){
		this.appender = appender;
	}
	
	@Override
	public void setFilter(Filter filter){
		this.filter = filter;
	}
	
	private void start(){
		if(executor == null || !executor.isAlive()) startControll();
	}
	
	synchronized private void startControll(){
		if(executor == null || !executor.isAlive()){
			controller = new Controller(appender, layout, messageQueue);
			executor = new Thread(controller);
			executor.start();
		}
	}
}
