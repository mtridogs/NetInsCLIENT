package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.sql.ResultSet;

public class imforma {
DataOutputStream dataout =null;
DataInputStream datain = null;
Socket so= null;
ResultSet rs =null;
File file=null;
static String username=null;
static String bip = null;
static String ipnow =null;
static String myip =null;
static String password =null;
static String usernamezt[][]=null;
static String snedstext = null;
static String sendsipforchar =null;
static String friends_ip_name =null;
static String file_ip=null;

static String ip_forwindowsopen =null;
static String username_forwindows =null;
static boolean asd = true;
static String myusername_foraddfriend = null;
static String myusername_friend =null;
static boolean boocl= true;



public imforma(DataOutputStream dataout,DataInputStream datain,Socket so)
{
this.dataout = dataout;
this.datain = datain;
this.so = so;

}

public imforma(){
	
	
}


public DataOutputStream getDataout() {
	return dataout;
}

public void setDataout(DataOutputStream dataout) {
	this.dataout = dataout;
}

public DataInputStream getDatain() {
	return datain;
}

public void setDatain(DataInputStream datain) {
	this.datain = datain;
}

public Socket getSo() {
	return so;
}

public void setSo(Socket so) {
	this.so = so;
}
public void setboll(boolean a)
{
this.asd=a;	
}
	
	
	
}