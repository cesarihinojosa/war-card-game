package hw2;

import hw2.gameversions.GameOfWar;
import hw2.gameversions.GameOfWarVersionOne;

public class PlayGame {
    
    public static void play(){
        //TODO: change this to depend on the command arguments
        GameOfWar gameOfWar = new GameOfWarVersionOne();
        gameOfWar.setupGame.setup(gameOfWar.players);
        //in loop
        gameOfWar.gameRound.playRound();
        //in loop
        gameOfWar.pointSystem.countPoints();
    }

}
