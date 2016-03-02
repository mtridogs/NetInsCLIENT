package com.neusoft.qq.client.biz;

import java.io.IOException;

import javax.swing.JTextArea;

import com.neusoft.qq.client.po.ClientPoint;

public class Receiver implements Runnable {

	private JTextArea showMsgArea;
	
	public static boolean bool = true;
	
	public Receiver(JTextArea showMsgArea) {
		this.showMsgArea = showMsgArea;
	}
	
	@Override
	public void run() {
		
		ClientManager.start();
		
		while(bool){
			System.out.println("==============");
			String msg = null;
			try {
				msg = ClientManager.cp.getDis().readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(msg != null && !msg.isEmpty()){
				showMsgArea.append(msg);
			}
		}
	}

}
