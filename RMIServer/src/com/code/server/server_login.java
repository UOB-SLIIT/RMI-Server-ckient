package com.code.server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class server_login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					server_login window = new server_login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public server_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 868, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 852, 390);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("User Name :");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(237, 131, 128, 28);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Password :");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_2.setBounds(237, 176, 112, 28);
		panel.add(label_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setColumns(10);
		textField.setBounds(366, 131, 197, 28);
		panel.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(366, 176, 197, 27);
		panel.add(passwordField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 852, 48);
		panel.add(panel_1);
		
		JLabel label_3 = new JLabel("Please Login");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_3.setBounds(10, 11, 136, 26);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		label_4.setIcon(new ImageIcon("C:\\Users\\Tharaka\\Desktop\\img\\cancel.png"));
		label_4.setBounds(802, 0, 40, 51);
		panel_1.add(label_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 363, 852, 27);
		panel.add(panel_2);
		
		JButton button = new JButton("RESET");
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(401, 253, 134, 38);
		panel.add(button);
		
		JButton button_1 = new JButton("LOGIN");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBounds(289, 253, 89, 38);
		panel.add(button_1);
		frame.setLocationRelativeTo(null);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*
				 * try { String result=Databaseworks.getLoggedin("admin", textField.getText(),
				 * passwordField.getText()); if(result.equalsIgnoreCase("Success")) { new
				 * server_main(); frame.setVisible(false); }else {
				 * JOptionPane.showMessageDialog(null, result); } } catch (Exception e1) { //
				 * TODO Auto-generated catch block e1.printStackTrace(); }
				 */
				//
				try {
					String result=Databaseworks.getLoggedin("admin", textField.getText(), passwordField.getText());
					if(result.equalsIgnoreCase("Success")) {
						JOptionPane.showMessageDialog(null, result);
					}else {
						new server_main();
						frame.setVisible(false);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				//
				
			}
		});

		JLabel label2 = new JLabel("");
		label2.setIcon(new ImageIcon("C:\\Users\\Tharaka\\Desktop\\img\\login.jpg"));
		label2.setBounds(200, 50,852, 390);
		panel.add(label2);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Tharaka\\Desktop\\img\\doctor-icon.png"));
		label.setBounds(0, 0, 200, 390);
		panel.add(label);
		
	
	}

}
