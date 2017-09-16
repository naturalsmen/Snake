import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		//Creating the window with all its awesome snaky features
		Menu f1= new Menu();
		
		//Setting up the window settings
		f1.setTitle("Snake");
		f1.setSize(300,80);
		f1.setLocationRelativeTo(null);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
