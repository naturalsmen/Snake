##JAVA SNAKE GAME


A simple snake game in java .
Using Threads and Java Swing to display the game.
The code is well commented, if you have any questions or want to continue this project feel free to do so :)

##Preview:

![alt tag](http://i62.tinypic.com/behbw3.png)

##How to run the game:

###Requirements:
* Java runtime installed

###Procedure:

* Just download the SnakeGame.jar file
* Run it 
* Start playing with the arrows keys. 
* If you lose, just close it and re-open it (I will add a restart button possibly)




Made in a couple of hours ..

---
##Updates
In DataofSquare.java, new hitch, named "shit", is added. 
Notes previous author use to specify color to object are fixed.

To enhence entertainment, the difficulty is set to "Simple" and "Hard".
For the Simple mode, length of snake less one unit if eating shit, namely red object.
For the Hard mode, player fails only if the snake bangs into the hitch.
The adjustment is made in several files, including the creation of new class, "Menu.java".
A new variable, level, is generated to control the difficulty in ThreadController.java. 
When level equals 1, which is specified in "ActionListener" in Menu.java, the difficulty will be Simple, and vice versa.

In the previous version, the window closes once you lose. 
To continue the game without re-open it, Menu pops up again whenever the player loses.
Hence, by choosing the difficulty level again, a new game emerges.
The above modifications shows in "Menu.java".

The displays in the center once the program is activated, which is adjusted in "Message.java" as well as "Window.java".

To better understand these modifications, see the commitment message in each file.
