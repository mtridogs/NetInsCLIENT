package test;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class searchfriend extends javax.swing.JFrame {
	private JLabel username;
	private JButton jButton1;
	private JTextField jTextField1;
    imforma imforma;
    public static String serverip ="10.25.130.152";
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				searchfriend inst = new searchfriend();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public searchfriend() {
		super();
		initGUI();
		mygui();
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	private void mygui() {
		
		
		
		
		
		jButton1.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent arg0) {
				imforma.myusername_friend = jTextField1.getText();
				System.out.println("传送好友信息，这里是添加好友界面=====================");
				try {
					Socket soos = new Socket(serverip,6256);
					DataOutputStream dataout = new DataOutputStream(new BufferedOutputStream(soos.getOutputStream()));
					DataInputStream datain = new DataInputStream(new BufferedInputStream(soos.getInputStream()));
					dataout.writeUTF(imforma.myusername_friend);
					dataout.flush();
					dataout.writeUTF(test.imforma.myusername_foraddfriend);
					
					
					dataout.flush();
					
					JOptionPane.showMessageDialog(searchfriend.this,"添加成功","警告",JOptionPane.WARNING_MESSAGE);
					datain.close();
					dataout.close();
					soos.close();
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				username = new JLabel();
				username.setText("\u8bf7\u8f93\u5165\u5bf9\u65b9\u540d\u79f0\uff1a");
			}
			{
				jTextField1 = new JTextField();
			}
			{
				jButton1 = new JButton();
				jButton1.setText("\u786e\u8ba4");
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(60, 60)
				.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(32)
				.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(47)
				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(75, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(39, 39)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(username, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 146, Short.MAX_VALUE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGap(46)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(thisLayout.createSequentialGroup()
				                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGap(25)
				                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 26, Short.MAX_VALUE)))))
				.addContainerGap(95, 95));
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
