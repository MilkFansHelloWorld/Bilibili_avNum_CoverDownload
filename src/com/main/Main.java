package com.main;

import com.GUI.UIFrame;

public class Main {
	//Console Version: 
	/*public static void main(String[] args) {
		String status=null;
		Scanner input=new Scanner(System.in);
		//Download download=new Download();
		Download d=new Download();
		ImgUrl imgUrl=new ImgUrl();
		System.out.println("��1����"+"\t"+"��0�˳�");
		status=input.next();
		while ((!status.equals("1"))||(!status.equals("0"))){
			if (status.equals("1")){
				System.out.println("����AV��");
				System.out.println("�����غõ��ļ�������������·���£�");
				String nb=input.next();
				String urlString=imgUrl.getCoverUrl("http://www.bilibili.com/video/av"+nb);
				System.out.println("URL: "+urlString);
				File file=new File(nb+".jpg");
				if(!file.exists()){
					try {
						file.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.err.println(e);
					}
				}
				d.downloadFromUrl(urlString, "", file.getName());
			}else if(status.equals("0")){
				System.exit(Integer.parseInt(status));
			}
			System.out.println("��1����"+"\t"+"��0�˳�");
			status=input.next();
		}
	}*/
	//GUI version: 
	public static void main(String[] args) {
		UIFrame frame=UIFrame.init();
		frame.setVisible(true);
	}
}
