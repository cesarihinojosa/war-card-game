package hw2.gameversions;

import hw2.coreobjects.Player;
import hw2.coreobjects.PlayerVersionTwo;
import hw2.gamecomponents.GameRoundVersionOne;
import hw2.gamecomponents.PointSystemVersionTwo;
import hw2.gamecomponents.SetupGameVersionOne;
import hw2.gamecomponents.WarRoundVersionTwo;

public class GameOfWarVersionThree extends GameOfWar{

public GameOfWarVersionThree(){
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
    Player playerThree = new PlayerVersionTwo();
    playerOne.setName("Player 1");
    playerTwo.setName("Player 2");
    playerThree.setName("Player 3");
    players = new Player[3];
    players[0] = playerOne;
    players[1] = playerTwo;
    players[2] = playerThree;
}

    @Override
    public void setNextGameOfWar(GameOfWar nextGameOfWar) {
        this.nextGameOfWar = nextGameOfWar;
    }

    @Override
    public GameOfWar handleGameOfWarVersion(int gameOfWarVersion) {
        if(gameOfWarVersion == 3){
            return this;
        }
        else{
            return nextGameOfWar.handleGameOfWarVersion(gameOfWarVersion);
        }
    }
    
}
