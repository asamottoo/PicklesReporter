/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.appender;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author t.asamoto
 */
abstract public class AbstractFileAppender implements Appender {
	
	protected String fileName = "/var/log/pickles/Sample.log";
	
	protected File targetFile = null;
	
	protected FileWriter fw = null;
	
	protected BufferedWriter bw = null;
	
	protected PrintWriter pw = null;
	
	protected boolean canOutput = false;

	public String getFileName(){
		return fileName;
	}
	
	abstract protected void closeWriter();

	abstract protected void openWriter();

}