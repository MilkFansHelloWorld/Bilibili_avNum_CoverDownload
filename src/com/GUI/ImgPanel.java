package com.GUI;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Panel;

public class ImgPanel extends Panel {
	Image img;

	public ImgPanel(Image img) {
		this.img = img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, 0, 0, 320, 200, this);// ���еڶ�������������ֱ�Ϊx,y,width,height
	}
}
