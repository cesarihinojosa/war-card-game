Overall, I used composition to write this program. The Game of War is 
built by 4 components: setting up the game, playing a round, playing a 
round of war, and the point system. Different versions have their own 
implementation for some of these, and also reuse components from other 
versions when they can. This allows for code reuse and also, ease of 
extension for future versions. 

The program itself follows the open/closed principle. This is mainly 
achieved by using a chain of responsibility. The program allows for future 
versions to be implemented and connected very easily. 

I would say pretty much all the classes follow single responsibility. 
There are 19 classes in this program. I tried to separate responsibility 
as much as possible. 

I used polymorphism when creating GameOfWar objects, see ‘PlayGame.java’. 
A GameOfWar object is being created, and at runtime, it’s decided which 
child class is used. I avoided using switch statements, instead using 
chain of responsibility and polymorphism. 

By using interfaces for each of the 4 game components, and having each 
GameOfWar version depend on these abstractions, this is an example of 
dependency inversion. 
