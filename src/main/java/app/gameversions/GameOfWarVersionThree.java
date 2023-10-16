package app.gameversions;

import app.coreobjects.Player;
import app.coreobjects.PlayerVersionTwo;
import app.gamecomponents.GameRoundVersionOne;
import app.gamecomponents.PointSystemVersionTwo;
import app.gamecomponents.SetupGameVersionOne;
import app.gamecomponents.WarRoundVersionTwo;

public class GameOfWarVersionThree extends GameOfWar {

    public GameOfWarVersionThree() {
        createPlayers();
        setupGame = new SetupGameVersionOne();
        gameRound = new GameRoundVersionOne();
        pointSystem = new PointSystemVersionTwo();
        warRound = new WarRoundVersionTwo();
        limitOnRounds = false;
    }

    private void createPlayers() {
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
        if (gameOfWarVersion == 3) {
            return this;
        } else {
            return nextGameOfWar.handleGameOfWarVersion(gameOfWarVersion);
        }
    }

}
