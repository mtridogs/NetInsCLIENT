package test;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.neusoft.qq.server.biz.ServerManager;


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
public class server extends javax.swing.JFrame {
	private JMenuBar jMenuBar1;
	private JTextArea showMsgArea;
	private JScrollPane jScrollPane2;
	private JMenuItem wenjian_send;
	private JMenu jMenu2;
	private JButton sendBut;
	private JTextArea sendMsgArea;
	private JScrollPane jScrollPane1;
	private JMenu jMenu1;
	
	
	private ServerManager manager;
	
	private String name = "对面:";

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				server inst = new server();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public server() {
		super();
		initGUI();
		
		myinit();
	}
	
	
	
	
	private void myinit() {
		
		
		this.setTitle("消息窗口");
				manager = new ServerManager();
				
				manager.receive(showMsgArea);

		sendBut.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent arg0) {
				
				String sendMsg = sendMsgArea.getText();
				if(sendMsg != null && sendMsg.length()>0){
					
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
		
		new Thread(new Runnable() {
			
		
			public void run() {
				try {
					ServerSocket server = new ServerSocket(6542);
					Socket sockets = server.accept();
					DataInputStream datain = new DataInputStream(new BufferedInputStream( sockets.getInputStream()));
					DataOutputStream dataout = new DataOutputStream(new BufferedOutputStream(sockets.getOutputStream()));
					if(JOptionPane.showConfirmDialog(server.this,"对方尝试传送文件，是否接收？","警告",JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_OPTION)
					{
						System.out.println("开始接收文件");
						dataout.writeInt(1);
						dataout.flush();
						JFileChooser chooser = new JFileChooser();
						FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images & TXT", "jpg", "gif", "txt");
						chooser.setFileFilter(filter);
						chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						int returnVal = chooser.showSaveDialog(server.this);
			
						String filepath=chooser.getSelectedFile().getPath();
						System.out.println(filepath);
						String fileName = datain.readUTF();
						System.out.println("filepath=="+filepath+"name = = ===== "+fileName);
						OutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath,fileName)));
						long totalLength = datain.readLong();
						System.out.println("文件头发送完毕=====================》》");
						byte[] buffer = new byte[1024];
						Thread.sleep(10000);
						int length = 0;
						while (totalLength > 0) {
							if(totalLength - buffer.length > 0){
								length = buffer.length;
							}else{
								length = (int)totalLength;
							}
							datain.read(buffer,0,length);
							os.write(buffer,0,length);
							os.flush();
							totalLength -= length;
						}
						JOptionPane.showMessageDialog(server.this,"文件接收成功","警告",JOptionPane.YES_NO_OPTION);
						
					}
					else
					{
						dataout.writeInt(0);
						JOptionPane.showConfirmDialog(server.this,"终止传输。","警告",JOptionPane.WARNING_MESSAGE);
					}
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
	}

	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
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
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addComponent(sendBut, GroupLayout.Alignment.LEADING, 0, 118, Short.MAX_VALUE))
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(sendBut, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)))
				.addContainerGap(158, 158));
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("\u8bbe\u7f6e");
				}
				{
					jMenu2 = new JMenu();
					jMenuBar1.add(jMenu2);
					jMenu2.setText("\u529f\u80fd");
					{
						wenjian_send = new JMenuItem();
						jMenu2.add(wenjian_send);
						wenjian_send.setText("\u6587\u4ef6\u4f20\u8f93");
					}
				}
			}
			pack();
			this.setSize(594, 481);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
