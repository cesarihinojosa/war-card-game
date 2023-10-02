package hw2.gameversions;

import hw2.coreobjects.Player;
import hw2.coreobjects.PlayerVersionTwo;
import hw2.gamecomponents.GameRoundVersionOne;
import hw2.gamecomponents.PointSystemVersionTwo;
import hw2.gamecomponents.SetupGameVersionOne;
import hw2.gamecomponents.WarRoundVersionTwo;

public class GameOfWarVersionTwo extends GameOfWar{
    
    public GameOfWarVersionTwo(){
        Player playerOne = new PlayerVersionTwo();
        playerOne.setName("Player 1");
        Player playerTwo = new PlayerVersionTwo();
        playerTwo.setName("Player 2");
        players = new Player[2];
        players[0] = playerOne;
        players[1] = playerTwo;
    
        setupGame = new SetupGameVersionOne();
        gameRound = new GameRoundVersionOne();
        pointSystem = new PointSystemVersionTwo();
        warRound = new WarRoundVersionTwo();
    }

}
