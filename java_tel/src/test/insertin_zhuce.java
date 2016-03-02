package test;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
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
public class insertin_zhuce extends javax.swing.JFrame {
	private JLabel username_txt;
	private JLabel emailadd_txt;
	private JTextField password_enter;
	private JTextField username_enter;
	private JTextField email_enter;
	private JTextField nicheng_enter;
	private JButton zhuce_but;
	private JLabel nicheng_txt;
	private JLabel passwrod_txt;
	public static String serverip ="10.25.130.152";
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				insertin_zhuce inst = new insertin_zhuce();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public insertin_zhuce() {
		super();
		initGUI();
		
		mygui();
		
		
	}
	
	private void mygui() {
		
		zhuce_but.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
				String username = username_enter.getText();
				String email = email_enter.getText();
				String nicheng = nicheng_enter.getText();
				String password = password_enter.getText();
				
					try {
						Integer l =zhuce_jie(username,password,nicheng,email);
						System.out.println(l);
						if(l.equals(0))
						{
							JOptionPane.showMessageDialog(insertin_zhuce.this,"注册成功，欢迎成为公司会员！！","恭喜",JOptionPane.WARNING_MESSAGE);
						}
						else
						{
							
							JOptionPane.showMessageDialog(insertin_zhuce.this,"注册失败，原因可能是出现重复用户名","警告",JOptionPane.WARNING_MESSAGE);
						}
							
						
						
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
			
				
				
			}
		});
		
		
		
}

	public int zhuce_jie(String username,String password,String nicheng,String email) throws IOException, InterruptedException
	{
		Socket so= new Socket(serverip,8889);
		
		DataOutputStream dataout =new DataOutputStream(new BufferedOutputStream(so.getOutputStream()));
		DataInputStream datain = new DataInputStream(new BufferedInputStream(so.getInputStream()));
		dataout.writeUTF(username);
		dataout.flush();
		dataout.writeUTF(password);
		dataout.flush();
		dataout.writeUTF(nicheng);
		dataout.flush();
		dataout.writeUTF(email);
		dataout.flush();
		int s = datain.readInt();
		return s;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("test/1.jpg")).getImage());
			this.setTitle("AL2014");
			{
				username_txt = new JLabel();
				username_txt.setText("\u7528\u6237\u540d");
			}
			{
				passwrod_txt = new JLabel();
				passwrod_txt.setText("\u5bc6\u7801");
			}
			{
				nicheng_txt = new JLabel();
				nicheng_txt.setText("\u6635\u79f0");
			}
			{
				emailadd_txt = new JLabel();
				emailadd_txt.setText("E-mail");
			}
			{
				zhuce_but = new JButton();
				zhuce_but.setText("\u786e\u8ba4\u6ce8\u518c");
			}
			{
				nicheng_enter = new JTextField();
			}
			{
				email_enter = new JTextField();
			}
			{
				username_enter = new JTextField();
			}
			{
				password_enter = new JTextField();
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(42, 42)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(username_enter, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(username_txt, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(17)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(password_enter, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(passwrod_txt, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(nicheng_enter, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(nicheng_txt, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(email_enter, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(emailadd_txt, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(26)
				.addComponent(zhuce_but, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(39, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(84, 84)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(emailadd_txt, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
				    .addComponent(nicheng_txt, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
				    .addComponent(passwrod_txt, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
				    .addComponent(username_txt, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
				.addGap(24)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(email_enter, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(nicheng_enter, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(password_enter, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(username_enter, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(zhuce_but, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 49, Short.MAX_VALUE)))
				.addContainerGap(104, 104));
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
