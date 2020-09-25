package com.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;

import com.tools.CoverDownload;
import com.tools.Download;

public class UIFrame extends Frame{
	ImgPanel imageZone;
	String name;
	public void setImageZone(ImgPanel imageZone) {
		this.imageZone = imageZone;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ImgPanel getImageZone() {
		return imageZone;
	}
	public String getName() {
		return name;
	}
	public UIFrame() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}
	public UIFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}
	public UIFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}
	public UIFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}
	public static UIFrame init(){
		//Init imports
		CoverDownload cd=new CoverDownload();
		//Init frame
		UIFrame frame=new UIFrame("Bilibili视频封面下载");
		frame.setBounds(200, 200, 350, 400);
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);
			}
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowIconified(e);
			}
		});
		//Init default variables
		String src="TestLogo.png";
		//Init main part: image display
		Panel imgPanel;
		imgPanel=new ImgPanel(Toolkit.getDefaultToolkit().createImage(src));
		frame.setImageZone((ImgPanel)imgPanel);
		imgPanel.setBounds(0, 0, 320, 200);
		//Init frame layout
		frame.setLayout(new BorderLayout(0, 10));
		//Header
		Label title=new Label("Bilibili视频封面下载", Label.CENTER);
		title.setFont(new Font("宋体", Font.BOLD, 20));
		Panel panel=new Panel();
		panel.add(title);
		//Body
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		//Form
		Box query=Box.createHorizontalBox();
		TextField tf=new TextField(12);
		tf.setMaximumSize(new Dimension(300, 500));
		Button submit=new Button("确认");
		submit.setMaximumSize(new Dimension(100, 100));
		//Add actionlistener
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ExceptionDialog dialog;
				// TODO Auto-generated method stub
				System.out.println(e.getActionCommand()+"is pressed");
				String source="TestLogo.png";
				int nb=0;
				try{
					nb=Integer.parseInt(tf.getText());
					
				}catch(NumberFormatException nfe){
					System.out.println(nfe);
					dialog=new ExceptionDialog(frame, "错误", true, "请输入正确的av号："+nfe);
					dialog.setVisible(true);
				}
				if(nb!=0){
					try {
						source=cd.download(nb);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(source.equals("错误，请检查您的网络，和av号的有效性")){
						dialog=new ExceptionDialog(frame, "错误", true,"错误，请检查您的网络，和av号的有效性");
						dialog.setVisible(true);
					}else{
						Image img=Toolkit.getDefaultToolkit().createImage(source);
						((ImgPanel) imgPanel).setImg(img);
						imgPanel.repaint();
					}
				}
			}
		});
		query.add(tf);
		query.add(submit);
		query.setAlignmentX(Box.CENTER_ALIGNMENT);
		/*iZ.setBackground(Color.GRAY);*/
		Label fileName=new Label(frame.getName(), Label.CENTER);
		fileName.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(query);
		panel.add(fileName);
		frame.add(panel, BorderLayout.NORTH);
		//ImgPanel ADD
		frame.add(imgPanel,BorderLayout.CENTER);
		return frame;
	}
}
