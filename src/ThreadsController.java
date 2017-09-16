import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.*;


//Controls all the game logic .. most important class in this project.
public class ThreadsController extends Thread {
	 ArrayList<ArrayList<DataOfSquare>> Squares= new ArrayList<ArrayList<DataOfSquare>>();
	 Tuple headSnakePos;
	 int sizeSnake=3;
	 public static long speed = 70;
	 public static int directionSnake ;
	 public static int level;

	 ArrayList<Tuple> positions = new ArrayList<Tuple>();
	 Tuple foodPosition;
	 Tuple shitPosition;
	 
	 //Constructor of ControlleurThread 
	 ThreadsController(Tuple positionDepart){
		//Get all the threads
		Squares=Window.Grid;
		
		headSnakePos=new Tuple(positionDepart.x,positionDepart.y);
		directionSnake = 1;

		//!!! Pointer !!!!
		Tuple headPos = new Tuple(headSnakePos.getX(),headSnakePos.getY());
		positions.add(headPos);
		
		foodPosition= new Tuple(Window.height-1,Window.width-1);
		spawnFood(foodPosition);
		
		shitPosition= new Tuple(Window.height-6,Window.width-6);
		spawnShit(shitPosition);

	 }
	 
	 //Important part :
	 public void run() {
		 while(true){
			 moveInterne(directionSnake);
			 checkCollision();
			 moveExterne();
			 deleteTail();
			 pauser();
		 }
	 }
	 
	 //delay between each move of the snake
	 private void pauser(){
		 try {
				sleep(speed);
		 } catch (InterruptedException e) {
				e.printStackTrace();
		 }
	 }
	 
	 //Checking if the snake bites itself or is eating
	 private void checkCollision() {
		 Tuple posCritique = positions.get(positions.size()-1);
		 for(int i = 0;i<=positions.size()-2;i++){
			 boolean biteItself = posCritique.getX()==positions.get(i).getX() && posCritique.getY()==positions.get(i).getY();
			 if(biteItself){
				 Message biteTail = new Message();
				 JPanel midPanel = new JPanel();
				 biteTail.setVisible(true);
				 biteTail.setTitle("Game Over!");
				 biteTail.setSize(300,100);
				 biteTail.setLocationRelativeTo(null);
				 midPanel.add(new JLabel("Hahaha, UCCU~~"));
				 biteTail.add(midPanel, BorderLayout.CENTER);
				 biteTail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				stopTheGame();
			 }
		 }
		 
		 boolean eatingFood = posCritique.getX()==foodPosition.y && posCritique.getY()==foodPosition.x;
		 if(eatingFood){
			 System.out.println("Yummy!");
			 sizeSnake=sizeSnake+1;
			 	foodPosition = getValAleaNotInSnake();

			 spawnFood(foodPosition);	
		 }
		 
		 boolean eatingShit = posCritique.getX()==shitPosition.y && posCritique.getY()==shitPosition.x;
		 if(eatingShit) {
			 if(level==1) {
				 System.out.println("Oh no! It eats like shit!");
				 sizeSnake=sizeSnake-1;
				 shitPosition = getValAleaNotInSnake();  
				 	spawnShit(shitPosition);
				 	if(sizeSnake==0) {
						 Message manyShits = new Message();
						 JPanel midPanel = new JPanel();
						 manyShits.setVisible(true);
						 manyShits.setTitle("Game Over!");
						 manyShits.setSize(300,100);
						 manyShits.setLocationRelativeTo(null);
						 midPanel.add(new JLabel("Dies in eating too many shits~"));
						 manyShits.add(midPanel, BorderLayout.CENTER);
						 manyShits.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						 DieInShit();
					 }
			 }
			 if(level==2) {
				 Message manyShits = new Message();
				 JPanel midPanel = new JPanel();
				 manyShits.setVisible(true);
				 manyShits.setTitle("Game Over!");
				 manyShits.setSize(300,100);
				 manyShits.setLocationRelativeTo(null);
				 midPanel.add(new JLabel("Dies in eating shit!"));
				 manyShits.add(midPanel, BorderLayout.CENTER);
				 manyShits.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 DieInShit();
			 }
		 }
	 }
	 
	//Dies cuz ate shit
		 private void DieInShit() {
			 System.out.println("Die in eating too many shits");
			 while(true) {
				 pauser();
			 }
		 }
	 
	 //Stops The Game
	 private void stopTheGame(){
		 System.out.println("COLISION! \n");
		 while(true){
			 pauser();
		 }
	 }
	 
	 //Put food in a position and displays it
	 private void spawnFood(Tuple foodPositionIn){
		 	Squares.get(foodPositionIn.x).get(foodPositionIn.y).lightMeUp(1);
	 }
	 
	//Put shit in a position and displays it
	 private void spawnShit(Tuple shitPositionIn){
		 Squares.get(shitPositionIn.x).get(shitPositionIn.y).lightMeUp(3);
	 }
	 
	 //return a position not occupied by the snake
	 private Tuple getValAleaNotInSnake(){
		 Tuple p ;
		 int ranX= 0 + (int)(Math.random()*19); 
		 int ranY= 0 + (int)(Math.random()*19); 
		 p=new Tuple(ranX,ranY);
		 for(int i = 0;i<=positions.size()-1;i++){
			 if(p.getY()==positions.get(i).getX() && p.getX()==positions.get(i).getY()){
				 ranX= 0 + (int)(Math.random()*19); 
				 ranY= 0 + (int)(Math.random()*19); 
				 p=new Tuple(ranX,ranY);
				 i=0;
			 }
		 }
		 return p;
	 }
	 
	 //Moves the head of the snake and refreshes the positions in the arraylist
	 //1:right 2:left 3:top 4:bottom 0:nothing
	 private void moveInterne(int dir){
		 switch(dir){
		 	case 4:
				 headSnakePos.ChangeData(headSnakePos.x,(headSnakePos.y+1)%20);
				 positions.add(new Tuple(headSnakePos.x,headSnakePos.y));
		 		break;
		 	case 3:
		 		if(headSnakePos.y-1<0){
		 			 headSnakePos.ChangeData(headSnakePos.x,19);
		 		 }
		 		else{
				 headSnakePos.ChangeData(headSnakePos.x,Math.abs(headSnakePos.y-1)%20);
		 		}
				 positions.add(new Tuple(headSnakePos.x,headSnakePos.y));
		 		break;
		 	case 2:
		 		 if(headSnakePos.x-1<0){
		 			 headSnakePos.ChangeData(19,headSnakePos.y);
		 		 }
		 		 else{
		 			 headSnakePos.ChangeData(Math.abs(headSnakePos.x-1)%20,headSnakePos.y);
		 		 } 
		 		positions.add(new Tuple(headSnakePos.x,headSnakePos.y));

		 		break;
		 	case 1:
				 headSnakePos.ChangeData(Math.abs(headSnakePos.x+1)%20,headSnakePos.y);
				 positions.add(new Tuple(headSnakePos.x,headSnakePos.y));
		 		 break;
		 }
	 }
	 
	 //Refresh the squares that needs to be 
	 private void moveExterne(){
		 for(Tuple t : positions){
			 int y = t.getX();
			 int x = t.getY();
			 Squares.get(x).get(y).lightMeUp(0);
			 
		 }
	 }
	 
	 //Refreshes the tail of the snake, by removing the superfluous data in positions arraylist
	 //and refreshing the display of the things that is removed
	 private void deleteTail(){
		 int cmpt = sizeSnake;
		 for(int i = positions.size()-1;i>=0;i--){
			 if(cmpt==0){
				 Tuple t = positions.get(i);
				 Squares.get(t.y).get(t.x).lightMeUp(2);
			 }
			 else{
				 cmpt--;
			 }
		 }
		 cmpt = sizeSnake;
		 for(int i = positions.size()-1;i>=0;i--){
			 if(cmpt==0){
				 positions.remove(i);
			 }
			 else{
				 cmpt--;
			 }
		 }
	 }
}