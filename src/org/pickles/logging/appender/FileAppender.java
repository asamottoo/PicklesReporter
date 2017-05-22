/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickles.logging.appender;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author t.asamoto
 */
public class FileAppender extends AbstractFileAppender implements Appender {

	public FileAppender(String fileName){
		this.fileName = fileName;
		this.targetFile = new File(fileName);
		try {
			this.fw = new FileWriter(targetFile);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		this.bw = new BufferedWriter(fw);
		this.pw = new PrintWriter(bw);
		
		canOutput = true;

	}
	@Override
	public void output(String message) {
		if(canOutput)pw.println(message);
	}

	@Override
	synchronized protected void closeWriter() {
		if(!canOutput)return;

		canOutput = false;
		if(pw != null)pw.close();

		try {
			if(bw != null)bw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		try {
			if(fw != null)fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		pw = null;
		bw = null;
		fw = null;
	}

	@Override
	 protected void openWriter() {

		try {
			this.fw = new FileWriter(targetFile);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		this.bw = new BufferedWriter(fw);
		this.pw = new PrintWriter(bw);


	}
	
	
	
	
}
