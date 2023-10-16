package app.gameversions;

import app.coreobjects.Player;
import app.coreobjects.PlayerVersionTwo;
import app.gamecomponents.GameRoundVersionOne;
import app.gamecomponents.PointSystemVersionTwo;
import app.gamecomponents.SetupGameVersionOne;
import app.gamecomponents.WarRoundVersionTwo;

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
