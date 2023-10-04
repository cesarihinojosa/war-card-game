package hw2.gameversions;

import hw2.coreobjects.Player;
import hw2.coreobjects.PlayerVersionOne;
import hw2.gamecomponents.GameRoundVersionOne;
import hw2.gamecomponents.PointSystemVersionOne;
import hw2.gamecomponents.SetupGameVersionOne;
import hw2.gamecomponents.WarRoundVersionOne;

public class GameOfWarVersionOne extends GameOfWar{
    
    public GameOfWarVersionOne(){
        createPlayers();
        setupGame = new SetupGameVersionOne();
        gameRound = new GameRoundVersionOne();
        pointSystem = new PointSystemVersionOne();
        warRound = new WarRoundVersionOne();
    }

    private void createPlayers(){
        Player playerOne = new PlayerVersionOne();
        Player playerTwo = new PlayerVersionOne();
        playerOne.setName("Player 1");
        playerTwo.setName("Player 2");
        players = new Player[2];
        players[0] = playerOne;
        players[1] = playerTwo;
    }

    @Override
    public void setNextGameOfWar(GameOfWar nextGameOfWar) {
        this.nextGameOfWar = nextGameOfWar;
    }

    @Override
    public GameOfWar handleGameOfWarVersion(int gameOfWarVersion) {
        if(gameOfWarVersion == 1){
            return this;
        }
        else{
            return nextGameOfWar.handleGameOfWarVersion(gameOfWarVersion);
        }
    }
}
