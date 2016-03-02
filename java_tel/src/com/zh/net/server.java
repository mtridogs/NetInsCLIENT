package com.zh.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server implements Runnable{

  String accept=null;
	public void server() throws Exception{
		String str =null;
		ServerSocket dis = new ServerSocket(8888);
		System.out.println("server done.......");
		Socket dos = dis.accept();

		DataInputStream datainput = new DataInputStream(new BufferedInputStream(dos.getInputStream()));
		System.out.println("=======================================");
		while(true)
		{
		str = datainput.readUTF();
		System.out.println(str);
		}

	}

	
	public void run(){
		try {
			server();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
}
