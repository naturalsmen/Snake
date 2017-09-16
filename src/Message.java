import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Message extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public JButton restart = new JButton("Revenge!");
	
	public Message() {
		Container cp = getContentPane(); 
	    cp.setLayout(new BorderLayout());
	    
  		JPanel bottomPanel = new JPanel();
  		bottomPanel.add(restart);
  		cp.add(bottomPanel, BorderLayout.SOUTH);
	    //cp.add(restart);
	    
	    restart.addActionListener(new ActionListener() {

	          public void actionPerformed(ActionEvent e) {
	        	//Creating the window with all its awesome snaky features
	      		Menu f1= new Menu();
	      		
	      		//Setting up the window settings
	      		f1.setTitle("Snake");
	      		f1.setSize(300,80);    //300 -> 500
	      		f1.setLocationRelativeTo(null);
	      		f1.setVisible(true);
	      		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      		
	      		//Close Menu once select
	      		String cmd = e.getActionCommand();
	      		if(cmd.equals("Revenge!"))
	            {
	                dispose();
	            }
	          };
	      });
	}
}