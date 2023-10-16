package app.gameversions;

import app.coreobjects.Player;
import app.coreobjects.PlayerVersionOne;
import app.gamecomponents.GameRoundVersionOne;
import app.gamecomponents.PointSystemVersionOne;
import app.gamecomponents.SetupGameVersionOne;
import app.gamecomponents.WarRoundVersionOne;

public class GameOfWarVersionOne extends GameOfWar{
    
    public GameOfWarVersionOne(){
        createPlayers();
        setupGame = new SetupGameVersionOne();
        gameRound = new GameRoundVersionOne();
        pointSystem = new PointSystemVersionOne();
        warRound = new WarRoundVersionOne();
        limitOnRounds = true;
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
