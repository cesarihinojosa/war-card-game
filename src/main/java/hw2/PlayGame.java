package hw2;

import hw2.coreobjects.Player;
import hw2.coreobjects.PlayerVersionOne;
import hw2.gameversions.GameOfWar;
import hw2.gameversions.GameOfWarVersionOne;

public class PlayGame {

    public static void play() {
        int numOfRounds = 100;// TODO: change this to depend on the command arguments
        GameOfWar gameOfWar = new GameOfWarVersionOne();
        PrintGame printGame = new PrintGame();

        gameOfWar.setupGame.setup(gameOfWar.players);
        for (int i = 0; i < numOfRounds; i++) {
            Player winner = new PlayerVersionOne("Winner");
            winner = gameOfWar.gameRound.playRound(gameOfWar.players);
            if (winner == null) {
                winner = gameOfWar.warRound.war(gameOfWar.players);
            }
            printGame.printCurrentStatus(gameOfWar, winner);
            if(gameOfWar.pointSystem.gameEnded(gameOfWar.players, winner)){
                break;
            }
        }
    }

}
