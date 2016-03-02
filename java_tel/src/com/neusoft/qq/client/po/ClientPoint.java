package com.neusoft.qq.client.po;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientPoint {

	private Socket so;
	private DataInputStream dis;
	private DataOutputStream dos;

	public ClientPoint(Socket so, DataInputStream dis, DataOutputStream dos) {
		super();
		this.so = so;
		this.dis = dis;
		this.dos = dos;
	}
	
	public Socket getSo() {
		return so;
	}
	public void setSo(Socket so) {
		this.so = so;
	}
	public DataInputStream getDis() {
		return dis;
	}
	public void setDis(DataInputStream dis) {
		this.dis = dis;
	}
	public DataOutputStream getDos() {
		return dos;
	}
	public void setDos(DataOutputStream dos) {
		this.dos = dos;
	}
	
	
}
