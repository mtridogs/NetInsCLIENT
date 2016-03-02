package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

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
public class tongxun_main extends javax.swing.JFrame {
	public JMenuBar jMenuBar1;
	public JScrollPane jScrollPane1;
	public JMenuItem jMenuItem2;
	public JMenuItem jMenuItem1;
	static public JTable jTable1;
	public JMenu jMenu1;
	static public TableModel jTable1Model;
	static public imforma imforma;
	public static String serverip = "10.25.130.152";

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				tongxun_main inst;
				try {
					inst = new tongxun_main(null);
					inst.setLocationRelativeTo(null);
					System.out
					.println("======================好友列表+++++++++++++++++++++++++++++++++++++++++++++");
					inst.setVisible(true);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}

	public tongxun_main(String nameuser) throws IOException {
		super();
		String ser[][] = initfriendshow(nameuser);
		test.imforma.usernamezt = ser;
		System.out.println("已经执行到此处===========这里是好友列表初始化界面=========>");
		initGUI(test.imforma.usernamezt);

		mygui();
	}

	public void mygui() {

		
		
		jMenuItem1.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						searchfriend inst = new searchfriend();
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
					}
				});
				
			}
		});
		
		
		
		
	
		
		
		
		
		new Thread(new Runnable() {
			public void run() {

					try {
						ServerSocket sockser = new ServerSocket(7412);
						sockser.accept();
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								server inst = new server();
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);

							}
						});

					} catch (IOException e) {

						e.printStackTrace();
					}




				

			}
		}).start();

		jTable1.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					int i = 0;
					public void valueChanged(ListSelectionEvent arg0) {

						i++;
						if (i == 1) {
							int row = jTable1.getSelectedRow();
							String neirong = (String) jTable1.getValueAt(jTable1.getSelectedRow(),0);

							test.imforma.friends_ip_name = neirong;
                           
							System.out.println(neirong);
							try {

								String friendsip = setipnow(neirong);
								test.imforma.ip_forwindowsopen = friendsip;
								test.imforma.username_forwindows = neirong;

								boolean a = false;
								
								int iv = 0;
								
								while (iv <= 4) {
									
									try {
										Socket socekt = new Socket(
												test.imforma.ip_forwindowsopen,
												7412);
									} catch (UnknownHostException e) {
										e.printStackTrace();
										JOptionPane.showMessageDialog(
												tongxun_main.this,
												"连接失败，对方可能已经不在线上！！没有找到主机,正在重连次数为"
														+ iv, "警告",
														JOptionPane.WARNING_MESSAGE);
										
									} catch (IOException e) {
										e.printStackTrace();
										JOptionPane.showMessageDialog(
												tongxun_main.this,
												"连接失败，对方可能已经不在线上！！没有找到端口正在重连次数为"
														+ iv, "警告",
														JOptionPane.WARNING_MESSAGE);
										
									}

									iv++;
								}
								
								
									
								SwingUtilities.invokeLater(new Runnable() {
									public void run() {
										try {

											Client inst = new Client(
													test.imforma.username_forwindows,
													test.imforma.ip_forwindowsopen);
							
											inst.setLocationRelativeTo(null);
											inst.setVisible(true);
										} catch (UnknownHostException e) {
											e.printStackTrace();
											JOptionPane
											.showMessageDialog(
													tongxun_main.this,
													"连接失败，没有找到主机！！！",
													"警告",
													JOptionPane.WARNING_MESSAGE);
										} catch (IOException e) {
											e.printStackTrace();
											JOptionPane.showMessageDialog(
													tongxun_main.this,
													"连接失败！！！",
													"警告",
													JOptionPane.WARNING_MESSAGE);
										} catch (Exception e) {
											e.printStackTrace();
											JOptionPane
											.showMessageDialog(
													tongxun_main.this,
													"连接失败！！！",
													"警告",
													JOptionPane.WARNING_MESSAGE);
										}
									}
								});
							
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
                           
					}
				});

		// ///////////// /////////////// /////////////// ///////////////
		// /////////////// /////////////// /////////////// ///////////////

	}

	public String[][] initfriendshow(String name) throws IOException {

		Socket dos2;
		dos2 = new Socket(serverip, 8726);

		String dataout = null;
		DataOutputStream dataoutput2 = new DataOutputStream(
				new BufferedOutputStream(dos2.getOutputStream()));
		DataInputStream dataInput = new DataInputStream(
				new BufferedInputStream(dos2.getInputStream()));
		System.out
		.println("=====================一切准备就绪，发送需要查询的用户名===============");
		dataoutput2.writeUTF(name);

		dataoutput2.flush();

		String[][] friends = new String[15][2];

		for (int l = 0; l < 15; l++) {
			friends[l][0] = dataInput.readUTF();
			if (friends[l][0].equals("error"))
				friends[l][0] = "空位置";
		}
		for (int lc = 0; lc < 15; lc++) {

			friends[lc][1] = dataInput.readUTF();

			if (friends[lc][1].equals("1"))
				friends[lc][1] = "在线";
			else if (friends[lc][1].equals("0"))
				friends[lc][1] = "离线";
			System.out.println(friends[lc][1]);

		}

		return friends;
	}

	public void initGUI(String[][] friends) {
		try {
			System.out.println("已经执行到此处=========好友列表执行界面初始化操作=========>");
			GroupLayout thisLayout = new GroupLayout(
					(JComponent) getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jScrollPane1 = new JScrollPane();
				{
					jTable1Model = new DefaultTableModel(friends, new String[] {
							"好友", "状态" });
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(jTable1Model);
					jTable1.setPreferredSize(new java.awt.Dimension(196, 635));
				}
			}

			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
					.addComponent(jScrollPane1, 0, 657, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
					.addComponent(jScrollPane1, 0, 199, Short.MAX_VALUE));
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("\u597d\u53cb");
					{
						jMenuItem1 = new JMenuItem();
						jMenu1.add(jMenuItem1);
						jMenuItem1.setText("\u6dfb\u52a0\u597d\u53cb");
					}
					{
						jMenuItem2 = new JMenuItem();
						jMenu1.add(jMenuItem2);
						jMenuItem2.setText("\u5220\u9664\u597d\u53cb");
					}
				}
			}
			pack();
			this.setSize(207, 709);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	public String setipnow(String username_forip) throws Exception, IOException {
		Socket dos2;
		dos2 = new Socket(serverip, 6986);

		String dataout = null;
		DataOutputStream dataoutput2 = new DataOutputStream(
				new BufferedOutputStream(dos2.getOutputStream()));
		DataInputStream dataInput = new DataInputStream(
				new BufferedInputStream(dos2.getInputStream()));

		dataoutput2.writeUTF(username_forip);
		dataoutput2.flush();
		String s = dataInput.readUTF();
		return s;

	}

}
