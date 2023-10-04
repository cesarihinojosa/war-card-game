package hw2.gameversions;

import hw2.coreobjects.Player;
import hw2.coreobjects.PlayerVersionTwo;
import hw2.gamecomponents.GameRoundVersionOne;
import hw2.gamecomponents.PointSystemVersionTwo;
import hw2.gamecomponents.SetupGameVersionOne;
import hw2.gamecomponents.WarRoundVersionTwo;

public class GameOfWarVersionTwo extends GameOfWar{
    
    public GameOfWarVersionTwo(){
        createPlayers();
        setupGame = new SetupGameVersionOne();
        gameRound = new GameRoundVersionOne();
        pointSystem = new PointSystemVersionTwo();
        warRound = new WarRoundVersionTwo();
        limitOnRounds = false;
    }

    private void createPlayers(){
        Player playerOne = new PlayerVersionTwo();
        Player playerTwo = new PlayerVersionTwo();
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
        if(gameOfWarVersion == 2){
            return this;
        }
        else{
            return nextGameOfWar.handleGameOfWarVersion(gameOfWarVersion);
        }
    }

}
