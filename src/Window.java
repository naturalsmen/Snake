import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;


class Window extends JFrame{
	private static final long serialVersionUID = -2542001418764869760L;
	public static ArrayList<ArrayList<DataOfSquare>> Grid;
	public static int width = 20;
	public static int height = 20;
	public Window(){
		
		
		// Creates the arraylist that'll contain the threads
		Grid = new ArrayList<ArrayList<DataOfSquare>>();
		ArrayList<DataOfSquare> data;
		
		// Creates Threads and its data and adds it to the arrayList
		for(int i=0;i<width;i++){
			data= new ArrayList<DataOfSquare>();
			for(int j=0;j<height;j++){
				DataOfSquare c = new DataOfSquare(2);
				data.add(c);
			}
			Grid.add(data);
		}
		
		// Setting up the layout of the panel
		getContentPane().setLayout(new GridLayout(20,20,0,0));
		
		// Start & pauses all threads, then adds every square of each thread to the panel
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				getContentPane().add(Grid.get(i).get(j).square);
			}
		}
		
		// initial position of the snake
		Tuple position = new Tuple(10,10);
		// passing this value to the controller
		ThreadsController c = new ThreadsController(position);
		//Let's start the game now..
		c.start();

		// Links the window to the keyboardlistenner.
		this.addKeyListener((KeyListener) new KeyboardListener());

		//To do : handle multiplayers .. The above works, test it and see what happens
		
		//Tuple position2 = new Tuple(13,13);
		//ControlleurThreads c2 = new ControlleurThreads(position2);
		//c2.start();
		
	}
}

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
