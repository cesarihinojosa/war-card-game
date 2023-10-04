package hw2;

import hw2.coreobjects.Player;
import hw2.coreobjects.PlayerVersionOne;
import hw2.gameversions.GameOfWar;
import hw2.gameversions.GameOfWarVersionOne;
import hw2.gameversions.GameOfWarVersionTwo;

public class PlayGame {

    static int numOfRounds = 200;// TODO: change this to depend on the command arguments
    static GameOfWar gameOfWar = new GameOfWarVersionTwo();
    static PrintGame printGame = new PrintGame();

    public static void play(String[] args) {
        String shuffleSeed = args[0];
        setupGame(Integer.parseInt(shuffleSeed));

        for (int i = 0; i < numOfRounds; i++) {
            Player winner = createPlayerObject();
            winner = playRound();
            if (winner == null) {
                printGame.printCardsInPlayWar(gameOfWar);
                winner = playWar();
            }
            if (gameEnded(winner)) {
                printEndOfGameInfo();
                break;
            }
            printGameInfo(winner);
        }
    }

    private static void setupGame(int shuffleSeed) {
        gameOfWar.setupGame.setup(gameOfWar.players, shuffleSeed);
    }

    private static Player createPlayerObject() {
        return new PlayerVersionOne();// change this to be variable
    }

    private static Player playRound() {
        return gameOfWar.gameRound.playRound(gameOfWar.players);
    }

    private static Player playWar() {
        return gameOfWar.warRound.war(gameOfWar.players);
    }

    private static boolean gameEnded(Player winner) {
        return gameOfWar.pointSystem.gameEnded(gameOfWar.players, winner);
    }

    private static void printGameInfo(Player winner) {
        printGame.printCardsInPlay(gameOfWar);
        printGame.printWinnerOfRound(gameOfWar.players, winner);
        printGame.printScore(gameOfWar.players);
        System.out.println();
    }

    private static void printEndOfGameInfo() {
        printGame.printCardsInPlay(gameOfWar);
        printGame.printWinnerOfGame(gameOfWar);
        printGame.printScore(gameOfWar.players);
        System.out.println();
    }

}
