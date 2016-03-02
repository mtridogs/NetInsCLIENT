package com.neusoft.qq.client.biz;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JTextArea;

import com.neusoft.qq.client.po.ClientPoint;

public class ClientManager {
	public static final int PORT = 7129;
	public static String IP=null;

	public static ClientPoint cp;
	

	/**
	 * 连接服务器服务
	 */
	public static void start() {
       
		Socket so = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			so = new Socket(IP, PORT);
			System.out.println("连接到服务器……");
			dis = new DataInputStream(new BufferedInputStream(
					so.getInputStream()));
			dos = new DataOutputStream(new BufferedOutputStream(
					so.getOutputStream()));
		} catch (IOException e) {
			
		}

		cp = new ClientPoint(so, dis, dos);
		
        

	}

	/**
	 * 向客户端发送消息
	 */
	public void send(final String msg) {
		if (cp != null) {
			new Thread(new Runnable() {

				@Override
				public void run() {

					try {
						cp.getDos().writeUTF(msg);
						cp.getDos().flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}).start();
		}
	}

	/**
	 * 接收消息
	 */
	public void receive(JTextArea showMsgArea) {
		new Thread(new Receiver(showMsgArea)).start();
	}
	public ClientManager(String ip)
	{
		this.IP=ip;
		
	}
}
