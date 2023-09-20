package hw2;

import hw2.gameversions.GameOfWar;
import hw2.gameversions.GameOfWarVersionOne;

public class PlayGame {
    
    public static void play(){
        GameOfWar gameOfWar = new GameOfWarVersionOne();
        gameOfWar.setupGame.setup();
        //in loop
        gameOfWar.gameRound.playRound();
        //in loop
        gameOfWar.pointSystem.countPoints();
    }

}
