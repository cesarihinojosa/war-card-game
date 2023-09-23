package hw2.gameversions;

import hw2.coreobjects.Player;
import hw2.gamecomponents.GameRoundVersionOne;
import hw2.gamecomponents.PointSystemVersionOne;
import hw2.gamecomponents.SetupGameVersionOne;
import hw2.gamecomponents.WarRoundVersionOne;

public class GameOfWarVersionOne extends GameOfWar{
    
    public GameOfWarVersionOne(){
        Player playerOne = new Player("Player 1");
        Player playerTwo = new Player("Player 2");
        players[0] = playerOne;
        players[1] = playerTwo;
        
        setupGame = new SetupGameVersionOne();
        gameRound = new GameRoundVersionOne();
        pointSystem = new PointSystemVersionOne();
        warRound = new WarRoundVersionOne();
    }

}
