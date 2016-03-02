package test;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.GroupLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;





public class NewJFrame extends javax.swing.JFrame {


	
	
	Container ct=null;
	BackgroundPanel bgp=null;
	private JLabel passwrod_text;
	private JLabel jLabel1;
	private JPasswordField password_enter;
	private JButton zhuce_button;
	private JButton deng_button;
	private JTextField username_enter;
	private JLabel denglu_text;
	public imforma imforma=null;
	public static String serverip ="10.25.130.152";
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			
				NewJFrame inst = new NewJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				
			}
		});
	}
	
	public NewJFrame() {
		super();
		initGUI();
		mygui();
	}
	public void mygui()
	{
		
		
		
		Image icimg = new ImageIcon("./src/10.jpg").getImage();
		ct=this.getContentPane();  
		bgp=new BackgroundPanel((new ImageIcon("c:/10.jpg")).getImage());  
		GroupLayout bgpLayout = new GroupLayout((JComponent)bgp);
		bgp.setLayout(bgpLayout);
	    bgp.setBounds(0,0,400,300); 
	    ct.add(bgp);  
	  this.setResizable(false);
	  this.setTitle("AL2014");
	  this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("test/1.jpg")).getImage());
	  
	  
	  
	    {
	    	denglu_text = new JLabel();
	    	denglu_text.setText("\u8d26\u53f7");
	    }
	    {
	    	jLabel1 = new JLabel();
	    	jLabel1.setText("jLabel1");
	    	jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("test/阿狸.jpg")));
	    }
	    {
	    	passwrod_text = new JLabel();
	    	passwrod_text.setText("\u5bc6\u7801");
	    }
	    {
	    	username_enter = new JTextField();
	    }
	    {
	    	deng_button = new JButton();
	    	deng_button.setText("\u767b\u9646");
	    	deng_button.setBackground(new java.awt.Color(0,128,255));
	    }
	    {
	    	zhuce_button = new JButton();
	    	zhuce_button.setText("\u6ce8\u518c");
	    	zhuce_button.setBackground(new java.awt.Color(0,128,255));
	    }
	    {
	    	password_enter = new JPasswordField();
	    }
		bgpLayout.setVerticalGroup(bgpLayout.createSequentialGroup()
			.addContainerGap(65, 65)
			.addGroup(bgpLayout.createParallelGroup()
			    .addGroup(bgpLayout.createSequentialGroup()
			        .addGroup(bgpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            .addComponent(username_enter, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			            .addComponent(denglu_text, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
			        .addGap(0, 99, Short.MAX_VALUE)
			        .addGroup(bgpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            .addComponent(deng_button, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
			            .addComponent(zhuce_button, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
			    .addGroup(bgpLayout.createSequentialGroup()
			        .addGap(0, 0, Short.MAX_VALUE)
			        .addGroup(bgpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            .addComponent(jLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
			            .addComponent(password_enter, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			            .addComponent(passwrod_text, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))))
			.addContainerGap(58, 58));
		bgpLayout.setHorizontalGroup(bgpLayout.createSequentialGroup()
			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addGroup(bgpLayout.createParallelGroup()
			    .addGroup(bgpLayout.createSequentialGroup()
			        .addGroup(bgpLayout.createParallelGroup()
			            .addComponent(denglu_text, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
			            .addComponent(passwrod_text, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
			        .addGap(8)
			        .addGroup(bgpLayout.createParallelGroup()
			            .addComponent(username_enter, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
			            .addComponent(password_enter, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
			    .addGroup(GroupLayout.Alignment.LEADING, bgpLayout.createSequentialGroup()
			        .addGap(0, 22, GroupLayout.PREFERRED_SIZE)
			        .addComponent(deng_button, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
			        .addGap(31)
			        .addComponent(zhuce_button, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
			.addContainerGap(32, 32));

		deng_button.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent arg0) {
				String getname =username_enter.getText();
				String getpass =password_enter.getText();
				imforma.username =getname;
				imforma.password =getpass;
				imforma.myusername_foraddfriend =getname;
				System.out.println("发送出去的用户名与密码是："+getname+"  "+getpass);
				try {
					int sl = collection(getname,getpass);
					System.out.println("s1="+sl);
					if(sl==0)
					{
						JOptionPane.showMessageDialog(NewJFrame.this,"不存在此用户名！请检查并重新输入","警告",JOptionPane.WARNING_MESSAGE);
						
					}
					else if(sl==3)
					{
						JOptionPane.showMessageDialog(NewJFrame.this,"密码出错","警告",JOptionPane.WARNING_MESSAGE);
						
					}
					else
					{
						String myip = InetAddress.getLocalHost().getHostAddress();  
						imforma.myip =myip;
						System.out.println("ip======>"+myip);
					
						JOptionPane.showMessageDialog(NewJFrame.this,"欢迎使用本产品","欢迎",JOptionPane.WARNING_MESSAGE);
				
						System.out.println("<======================进入IP连接发送=========================>");
						saveip(myip,getname);
						connupline(imforma.username);
						
						NewJFrame.this.setVisible(false);
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								tongxun_main inst;
								try {
									inst = new tongxun_main(imforma.username);
									inst.setLocationRelativeTo(null);
									System.out.println("======================好友列表+++++++++++++++++++++++++++++++++++++++++++++");
									inst.setVisible(true);
								} catch (IOException e) {
								
									e.printStackTrace();
								}
							
							}
						});
						
						
						
						
					}
					
					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
			}
		});
		

		zhuce_button.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				insertin_zhuce in = new insertin_zhuce();
				in.main(null);
				
			}
		});
		
		
		
		
		
		}
	public void saveip(String ip,String username) throws Exception, IOException
	{
		
		System.out.println("==============================开始发送IP===============================");
		Socket dos = new Socket(serverip,5675);
		System.out.println("==============================IP服务器连接完成=这里是连接IP的实验==============================");
		
		DataInputStream datainput = new DataInputStream(new BufferedInputStream(dos.getInputStream()));
		DataOutputStream dataoutput = new DataOutputStream(new BufferedOutputStream(dos.getOutputStream()));
		System.out.println("===================发送数据IP，以及用户名===========================");
		dataoutput.writeUTF(ip);
		dataoutput.flush();
		dataoutput.writeUTF(username);
		dataoutput.flush();
		System.out.println("这里是ip更新函数，这里发送的ip 是"+ip);
		
	}
	
	public void connupline(String name) throws UnknownHostException, IOException
	{

		Socket so = new Socket(serverip,5689);
		DataInputStream datain = new DataInputStream(new BufferedInputStream(so.getInputStream()));
		DataOutputStream dataout = new DataOutputStream(new BufferedOutputStream(so.getOutputStream()));
		dataout.writeUTF(name);
		dataout.flush();
	}
	
	
	public void connectuponlion(String name) throws UnknownHostException, IOException
	{
		Socket so = new Socket(serverip,9898);
		DataInputStream datain = new DataInputStream(new BufferedInputStream(so.getInputStream()));
		DataOutputStream dataout = new DataOutputStream(new BufferedOutputStream(so.getOutputStream()));
		dataout.writeUTF(imforma.username);
		dataout.flush();
	}
	
	
	
	
	public int collection(String name,String pass) throws UnknownHostException, IOException
	{
	
		Socket so= new Socket(serverip,8888);
		
		DataOutputStream dataout =new DataOutputStream(new BufferedOutputStream(so.getOutputStream()));
		DataInputStream datain = new DataInputStream(new BufferedInputStream(so.getInputStream()));
		dataout.writeUTF(name);
		dataout.flush();
		dataout.writeUTF(pass);
		dataout.flush();
	
		int s = datain.readInt();
		
		
		
		
		return s;
	}
	
	
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
