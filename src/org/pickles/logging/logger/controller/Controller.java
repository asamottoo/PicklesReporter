/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.logger.controller;

import java.util.Queue;
import org.pickles.logging.appender.Appender;
import org.pickles.logging.layout.Layout;

/**
 *
 * @author t.asamoto
 */
public class Controller implements Runnable {
	
	private Layout layout = null;
	private Appender appender = null;
	private Queue<String> messageQueue = null;
	private int limit = 1000;
	private long waitTime = 100000l;
	
	public Controller(Appender appender, Layout layout, Queue queue){
		this.appender = appender;
		this.layout = layout;
		this.messageQueue = queue;
	}

	@Override
	public void run() {
		int tryNum = 0;
		
		while(tryNum < limit){

			String message = messageQueue.poll();
			if(message == null){
				tryNum++;
				try {
					Thread.sleep(1l);
				} catch (InterruptedException ex) {}
				continue;
			}
			appender.output(layout.convert(message));
			tryNum = 0;
		}
	}
	
	
	
}
