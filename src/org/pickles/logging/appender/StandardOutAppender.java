/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.appender;

/**
 *
 * @author t.asamoto
 */
public class StandardOutAppender implements Appender {

	@Override
	synchronized public void output(String message) {
		System.out.println(message);
	}
	
}
