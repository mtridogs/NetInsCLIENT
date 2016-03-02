package com.zh.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import test.NewJFrame;

public class client implements Runnable{
	   String  ip ;
	   int port  = 7926;
	   JTextArea jtext = null;
	   
	   
	   public client(String ip,JTextArea jtxt)
	   {
		   this.ip=ip;
		   
		   this.jtext=jtxt;
	   }
	   
	   
	public void client(String sends,JTextArea jtxt) 
	{
		try {
			Socket dos2;
			
			dos2 = new Socket(ip,port);

			String dataout= null;
			DataOutputStream dataoutput2 = new DataOutputStream(new BufferedOutputStream(dos2.getOutputStream()));
while(true){
			System.out.println("=======");
			dataout = jtxt.getText();
			System.out.println(dataout);
			dataoutput2.writeUTF(dataout);
			dataoutput2.flush();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	
	}
	public void run(){
		try {
			client(null,null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
