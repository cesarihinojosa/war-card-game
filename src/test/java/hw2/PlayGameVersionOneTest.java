package hw2;

import org.junit.Test;

import hw2.coreobjects.Player;
import hw2.coreobjects.PlayerVersionOne;
import hw2.gameversions.GameOfWar;
import hw2.gameversions.GameOfWarVersionOne;

public class PlayGameVersionOneTest {

    int numOfRounds = 100;// TODO: change this to depend on the command arguments
    GameOfWar gameOfWar = new GameOfWarVersionOne();
    PrintGame printGame = new PrintGame();
    PrintGameExtra printGameExtra = new PrintGameExtra();

    //@Test
    public void play() {
        setupGame();
        for (int i = 0; i < numOfRounds; i++) {
            Player winner = createPlayerObject();
            winner = playRound();
            if (winner == null) {
                winner = playWar();
            }
            printStatus(winner);
            setPoints();
            printScore();
            checkIfGameEnded(winner);
            printPiles();
        }
    }

    private void setupGame() {
        gameOfWar.setupGame.setup(gameOfWar.players);
    }

    private Player createPlayerObject() {
        return new PlayerVersionOne();// change this to be variable
    }

    private Player playRound() {
        return gameOfWar.gameRound.playRound(gameOfWar.players);
    }

    private Player playWar() {
        printGame.printCurrentStatusWar(gameOfWar);
        return gameOfWar.warRound.war(gameOfWar.players);
    }

    private void printStatus(Player winner) {
        printGame.printCurrentStatusNormal(gameOfWar, winner);
    }

    private void checkIfGameEnded(Player winner) {
        if (gameOfWar.pointSystem.gameEnded(gameOfWar.players, winner)) {
            System.exit(0);
        }
    }

    private void setPoints() {
        gameOfWar.pointSystem.setPoints(gameOfWar.players);
    }

    private void printScore() {
        printGame.printScore(gameOfWar.players);
    }

    private void printPiles(){
        printGameExtra.printPiles(gameOfWar.players);
    }

}
