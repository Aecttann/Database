package bd;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.*;

public class Start {
	static JFrame frame;
	private static JLabel loginPlease;
	private static JLabel log_in;
	private static JTextField log_in_tf;
	private static JLabel pass_in;
	private static JTextField pass_in_tf;
	private static JButton bt_login;
	static String get_login;
	static String get_pass;
	static JLabel error;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				try{
					new Start();
					Start.frame.setVisible(true);
				}
				catch (Exception e){
					e.printStackTrace();
				}
			}
		});
}
	public Start(){
		initialize();
}
	
	
	private static void initialize(){
		frame = new JFrame("Вход");
		frame.setBounds(500, 200, 300, 200);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		loginPlease = new JLabel("Пожалуйста, войдите в аккаунт:");
		loginPlease.setBounds(45, 20, 200, 25);
		frame.getContentPane().add(loginPlease);
		
		log_in = new JLabel("Логин: ");
		log_in.setBounds(25, 50, 45, 25);
		frame.getContentPane().add(log_in);
		
		log_in_tf = new JTextField();
		log_in_tf.setBounds(90, 52, 114, 19);
		frame.getContentPane().add(log_in_tf);
		log_in_tf.setColumns(10);
		
		pass_in = new JLabel("Пароль: ");
		pass_in.setBounds(25, 80, 55, 25);
		frame.getContentPane().add(pass_in);
		
		pass_in_tf = new JTextField();
		pass_in_tf.setBounds(90, 82, 114, 19);
		frame.getContentPane().add(pass_in_tf);
		pass_in_tf.setColumns(10);
		
		bt_login = new JButton("Вход");
		bt_login.setBounds(60, 130, 160, 25);
		frame.getContentPane().add(bt_login);
		
		
		bt_login.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				get_login = log_in_tf.getText();
				get_pass = pass_in_tf.getText();
				if((get_login.equals(Users.admin_login) && get_pass.equals(Users.admin_password)) || (get_login.equals(Users.manager_login) && get_pass.equals(Users.manager_password)) || (get_login.equals(Users.seller_login) && get_pass.equals(Users.seller_password)) || (get_login.equals(Users.stockman_login) && get_pass.equals(Users.stockman_password))){
					Signed.main(null);
					frame.setVisible(false);
				}
				/*
				if(get_login.equals(Users.seller_login) && get_pass.equals(Users.seller_password)){
					Signed.main(null);
					frame.setVisible(false);
				}
				if(get_login.equals(Users.stockman_login) && get_pass.equals(Users.stockman_password)){
					Signed.main(null);
					frame.setVisible(false);
				}
				*/
				else {
					JFrame frameErr = new JFrame("Ошибка");
					frameErr.setBounds(550, 245, 300, 100);
					frameErr.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);	
					JLabel labeltxt = new JLabel("Неверно введен логин и/или пароль!");
					labeltxt.setBounds(37, 24, 300, 20);
					frameErr.getContentPane().add(labeltxt);
					frameErr.getContentPane().setLayout(null);
					frameErr.setResizable(false);
					frameErr.addWindowStateListener(new WindowStateListener(){
			            @Override
			            public void windowStateChanged(WindowEvent e){
			            	frameErr.setState(Frame.NORMAL);
			            }
			        });
					frameErr.setAlwaysOnTop(true);
					frameErr.setVisible(true);
				}
				/*
				if((get_login.equals(Users.seller_login) && (get_pass.equals(Users.seller_password)))){
		//			Signed.fromB.setEnabled(false);
					System.out.println("Я здесь был.");
					Signed.main(null);
					frame.setVisible(false);
				}
				*/
				
				/*
				else{
					JFrame frameErr = new JFrame("Ошибка");
					frameErr.setBounds(550, 245, 200, 100);
					frameErr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
					frameErr.setResizable(false);
					frameErr.addWindowStateListener(new WindowStateListener(){
			            @Override
			            public void windowStateChanged(WindowEvent e){
			            	frameErr.setState(JFrame.NORMAL);
			            }
			        });
					frameErr.setAlwaysOnTop(true);
					frameErr.setVisible(true);
				}
				*/
				
	}

});
		
	}
}
