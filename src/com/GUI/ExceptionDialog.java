package com.GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExceptionDialog extends Dialog {
	private String name;

	public ExceptionDialog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		// TODO Auto-generated constructor stub
	}

	public ExceptionDialog(Frame owner, String title, boolean modal, String name) {
		// Init Dialog
		super(owner, title, modal);
		this.name = name;
		this.setLayout(new BorderLayout());
		this.setVisible(false);
		Label label = new Label(name);
		this.add(label);
		this.setBounds(owner.getX() + 100, owner.getY() + 100, 100, 200);
		Button button = new Button("ȷ��");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);

			}
		});
		this.add(button, BorderLayout.SOUTH);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				setVisible(false);
			}
		});
		this.pack();
	}
}
