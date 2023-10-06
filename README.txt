War Card Game Simulator
Simulates a war game between computer players. Includes 3 versions of the game. Written in Java.


Running The Program
With Maven and Java installed, inside the project directory, run the following commands: 

	$ mvn package
      Mac/Linux:
	$ java -cp target/cs4773-hw2-1.0-SNAPSHOT.jar hw2.WarGame <arg1> <arg2> <arg3>
      Windows:
	$ java -cp target\cs4773-hw2-1.0-SNAPSHOT.jar hw2.WarGame <arg1> <arg2> <arg3>
	

Command Line Arguments
First argument is version of game. There are 3 versions. 1, 2, and 3.

If on version 1, second argument is number of rounds to play and third argument is shuffle seed. 

If not on version 1, second argument is shuffle seed and there is no third argument. 


Date: 10-05-2023
Author: Cesar Hinojosa
