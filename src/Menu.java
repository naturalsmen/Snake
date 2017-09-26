import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Menu extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public JButton Simple = new JButton("Simple");
	public JButton Hard = new JButton("Hard");
	
	//Simple Mode -> speed = 70
	//Hard Mode -> speed = 60
	public Menu() {
	  getContentPane().setLayout(new FlowLayout());
	  getContentPane().add(Simple);
	  getContentPane().add(Hard);

		Simple.addActionListener(new ActionListener() {

          public void actionPerformed(ActionEvent e) {
          	ThreadsController.speed = 70;
          	ThreadsController.level = 1;
        	Window f1= new Window();
          	f1.setTitle("Snake");
      		f1.setSize(600,600);    //300 -> 600
      		f1.setVisible(true);
      		f1.setLocationRelativeTo(null);
      		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      		
      		//Close Menu once select Simple
      		String cmd = e.getActionCommand();
      		if(cmd.equals("Simple"))
            {
                dispose();
            }
          };
      });
		
		Hard.addActionListener(new ActionListener() {

	          public void actionPerformed(ActionEvent e) {                 
	          	ThreadsController.speed = 50;
	          	ThreadsController.level = 2;
	        	Window f1= new Window();
	          	f1.setTitle("Snake");
	      		f1.setSize(600,600);    //300 -> 600
	      		f1.setVisible(true);
	      		f1.setLocationRelativeTo(null);
	      		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      		
	      		//Close Menu once select Hard
	      		String cmd = e.getActionCommand();
	      		if(cmd.equals("Hard"))
	            {
	                dispose();
	            }
	          };
	      });  
	}
}