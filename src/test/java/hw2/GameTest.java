package hw2;

import org.junit.Test;

import hw2.coreobjects.Player;
import hw2.coreobjects.PlayerVersionOne;
import hw2.gameversions.GameOfWar;
import hw2.gameversions.GameOfWarVersionOne;

public class GameTest {

    GameOfWar gameOfWar = new GameOfWarVersionOne();
    PrintGameExtra printGameExtra = new PrintGameExtra();
    PrintGame printGame = new PrintGame();

    @Test
    public void TestPlayingRounds() {
        int numberOfRounds = 40;
        printGameExtra.printTestStart();
        printGameExtra.printDeck();
        gameOfWar.setupGame.setup(gameOfWar.players);
        printGameExtra.printDeck();
        printGameExtra.printPiles(gameOfWar.players);
        for(int i = 0; i < numberOfRounds; i++){
            int indexOfWinner = gameOfWar.gameRound.playRound(gameOfWar.players);
            printGame.printCurrentStatus(gameOfWar, indexOfWinner);
            printGameExtra.printPlayersDetail(gameOfWar.players);
            if(indexOfWinner < 0){
                Player winner = new PlayerVersionOne("Winner");
                winner = gameOfWar.warRound.war(gameOfWar.players);
                printGame.printCurrentStatus(gameOfWar, winner);
                printGameExtra.printPlayersDetail(gameOfWar.players);
            }
        }
    }

}