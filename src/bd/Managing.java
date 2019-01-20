package bd;

import java.awt.*;
import javax.swing.*;

public class Managing {
	private static JFrame frame_managing;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				try{
					
					Managing window_reg = new Managing();
					Managing.frame_managing.setVisible(true);
				}
				catch (Exception e2){
					e2.printStackTrace();
				}
			}
		
		
});
	
	}
	
	private static void edit_goods(){
		
	}
	
}