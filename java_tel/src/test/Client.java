package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.neusoft.qq.client.biz.ClientManager;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class Client extends javax.swing.JFrame {
	private JMenuBar jMenuBar1;
	private JTextArea showMsgArea;
	private JScrollPane jScrollPane2;
	private JMenuItem jMenuItem1;
	private JMenu jMenu2;
	private JButton sendBut;
	private JTextArea sendMsgArea;
	private JScrollPane jScrollPane1;
	private JMenuItem startServerMenu;
	private JMenu jMenu1;
	
	public ClientManager manager;
	public String name =null;
	public  String username = null;
	public String forip=null; 

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Client inst;
				try {
					inst = new Client(null,null);
					inst.setLocationRelativeTo(null);
					inst.setVisible(true);
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

	public Client(String username,String ip) throws UnknownHostException, IOException {
		super();
		
		initGUI();
		imforma.file_ip = ip;
		myinit(username,ip);
	}

	public void myinit(String username,String ip) throws UnknownHostException, IOException {
		
		        this.setTitle("我与"+username+"的对话,他的IP地址是"+ip);
				manager = new ClientManager(ip);
				
				manager.receive(showMsgArea);
		        
				sendBut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String sendMsg = sendMsgArea.getText();
				if (sendMsg != null && sendMsg.length() > 0) {
				String str = "我 ["+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+"]：\n";
					str += "  " + sendMsg + "\n";
					showMsgArea.append(str);
					sendMsgArea.setText("");
					
					
			    String finalMsg = name + " ["+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+"]：\n" ;
					finalMsg += "  " + sendMsg + "\n";
					manager.send(finalMsg);
				}

			}
		});
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		jMenuItem1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						JFileChooser chooser = new JFileChooser();
						FileNameExtensionFilter filter = new FileNameExtensionFilter(
								"JPG & GIF Images & TXT", "jpg", "gif", "txt");
						chooser.setFileFilter(filter);
						int returnVal = chooser.showOpenDialog(Client.this);
						if (returnVal == JFileChooser.APPROVE_OPTION) {
							System.out.println("You chose to open this file: "
									+ chooser.getSelectedFile().getPath());
						}
						String filepath = chooser.getSelectedFile().getPath();
						
						try {
							Socket sos = new Socket(imforma.file_ip,6542);
							DataOutputStream dataout = new DataOutputStream(new BufferedOutputStream(sos.getOutputStream()));
							DataInputStream datain = new DataInputStream(new DataInputStream(sos.getInputStream()));
							InputStream input = new BufferedInputStream(new FileInputStream(filepath));
							File f = new File(filepath);
							
							int ok=datain.readInt();
							if(ok==1)
							{JOptionPane.showMessageDialog(Client.this,"对方同意接收文件，文件正在发送！","警告",JOptionPane.YES_NO_OPTION);
						      dataout.writeUTF(f.getName());
						      System.out.println("getName");
						      dataout.flush();
						      dataout.writeLong(f.length());
						      System.out.println("length");
							  dataout.flush();
							  byte[] buffer= new byte[1024];
							  int length =0;
							  while((length=input.read(buffer,0,buffer.length))!=-1)
							  {
								  dataout.write(buffer,0,length);
		                          dataout.flush();
							  }
							  JOptionPane.showMessageDialog(Client.this,"文件发送成功！","警告",JOptionPane.YES_NO_OPTION);
								dataout.close();
								sos.close();
							}
							else
							{JOptionPane.showMessageDialog(Client.this,"对方拒接文件接收！！","警告",JOptionPane.YES_NO_OPTION);}
							
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
			GroupLayout thisLayout = new GroupLayout(
					(JComponent) getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jScrollPane1 = new JScrollPane();
				{
					showMsgArea = new JTextArea();
					jScrollPane1.setViewportView(showMsgArea);
					showMsgArea.setLineWrap(true);
					showMsgArea.setEditable(false);
				}
			}
			{
				jScrollPane2 = new JScrollPane();
				{
					sendMsgArea = new JTextArea();
					jScrollPane2.setViewportView(sendMsgArea);
					sendMsgArea.setLineWrap(true);
				}
			}
			{
				sendBut = new JButton();
				sendBut.setText("\u53d1\u9001");
			}
			thisLayout
					.setVerticalGroup(thisLayout
							.createSequentialGroup()
							.addContainerGap()
							.addComponent(jScrollPane1,
									GroupLayout.PREFERRED_SIZE, 276,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(
									LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(
									thisLayout
											.createParallelGroup()
											.addGroup(
													thisLayout
															.createSequentialGroup()
															.addComponent(
																	jScrollPane2,
																	GroupLayout.PREFERRED_SIZE,
																	117,
																	GroupLayout.PREFERRED_SIZE)
															.addGap(0,
																	0,
																	Short.MAX_VALUE))
											.addComponent(
													sendBut,
													GroupLayout.Alignment.LEADING,
													0, 118, Short.MAX_VALUE))
							.addContainerGap());
			thisLayout
					.setHorizontalGroup(thisLayout
							.createSequentialGroup()
							.addContainerGap()
							.addGroup(
									thisLayout
											.createParallelGroup()
											.addGroup(
													thisLayout
															.createSequentialGroup()
															.addComponent(
																	jScrollPane1,
																	GroupLayout.PREFERRED_SIZE,
																	416,
																	GroupLayout.PREFERRED_SIZE)
															.addGap(0,
																	0,
																	Short.MAX_VALUE))
											.addGroup(
													GroupLayout.Alignment.LEADING,
													thisLayout
															.createSequentialGroup()
															.addComponent(
																	jScrollPane2,
																	GroupLayout.PREFERRED_SIZE,
																	343,
																	GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(
																	LayoutStyle.ComponentPlacement.RELATED)
															.addComponent(
																	sendBut,
																	GroupLayout.PREFERRED_SIZE,
																	62,
																	GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(
																	LayoutStyle.ComponentPlacement.RELATED,
																	0,
																	Short.MAX_VALUE)))
							.addContainerGap(158, 158));
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("\u8bbe\u7f6e");
					{
						startServerMenu = new JMenuItem();
						jMenu1.add(startServerMenu);
						startServerMenu.setText("\u9000\u51fa");
					}
				}
				{
					jMenu2 = new JMenu();
					jMenuBar1.add(jMenu2);
					jMenu2.setText("\u529f\u80fd");
					{
						jMenuItem1 = new JMenuItem();
						jMenu2.add(jMenuItem1);
						jMenuItem1.setText("\u6587\u4ef6\u4f20\u9001");
					}
				}
			}
			pack();
			this.setSize(594, 481);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
