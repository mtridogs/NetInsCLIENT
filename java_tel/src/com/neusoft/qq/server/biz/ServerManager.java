package com.neusoft.qq.server.biz;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

import com.neusoft.qq.server.po.ServerPoint;

public class ServerManager {

	public static final int PORT = 7129;

	public static ServerPoint sp;


	public static void start() {

		Socket so = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("��������������");
			so = server.accept();
			System.out.println("�пͻ����롭��");
			dis = new DataInputStream(new BufferedInputStream(
					so.getInputStream()));
			dos = new DataOutputStream(new BufferedOutputStream(
					so.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sp = new ServerPoint(so, dis, dos);

	}

	/**
	 * ��ͻ��˷�����Ϣ
	 */
	public void send(final String msg) {
		if (sp != null) {
			new Thread(new Runnable() {

				@Override
				public void run() {

					try {
						sp.getDos().writeUTF(msg);
						sp.getDos().flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}).start();
		}
	}

	/**
	 * ������Ϣ
	 */
	public void receive(JTextArea showMsgArea) {
		new Thread(new Receiver(showMsgArea)).start();
	}
}
