package hw2.gameversions;

import hw2.gamecomponents.GameRoundVersionOne;
import hw2.gamecomponents.PointSystemVersionOne;
import hw2.gamecomponents.SetupGameVersionOne;
import hw2.gamecomponents.WarRoundVersionOne;

public class GameOfWarVersionOne extends GameOfWar{
    
    public GameOfWarVersionOne(){
        setupGame = new SetupGameVersionOne();
        gameRound = new GameRoundVersionOne();
        pointSystem = new PointSystemVersionOne();
        warRound = new WarRoundVersionOne();
    }

}
