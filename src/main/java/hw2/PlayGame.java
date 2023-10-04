package hw2;

import hw2.coreobjects.Player;
import hw2.coreobjects.PlayerVersionOne;
import hw2.gameversions.GameOfWar;
import hw2.gameversions.GameOfWarVersionOne;
import hw2.gameversions.GameOfWarVersionTwo;

public class PlayGame {

    static int numOfRounds = 200;// TODO: change this to depend on the command arguments
    static PrintGame printGame = new PrintGame();

    static GameOfWar gameOfWar;
    static GameOfWar gameOfWarVersionOne;
    static GameOfWar gameOfWarVersionTwo;

    public static void play(String[] args) {

        createGameVersions();
        createChainOfResponsibilites();
        chooseGameVersionBasedOnCommandArgs(Integer.parseInt(args[0]));

        String shuffleSeed = args[1];
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
        System.out.println("seed: " + args[1]);
    }

    private static void createGameVersions(){
        gameOfWarVersionOne = new GameOfWarVersionOne();
        gameOfWarVersionTwo = new GameOfWarVersionTwo();
    }

    private static void createChainOfResponsibilites(){
        gameOfWarVersionOne.setNextGameOfWar(gameOfWarVersionTwo);
        gameOfWarVersionTwo.setNextGameOfWar(null);
    }

    private static void chooseGameVersionBasedOnCommandArgs(int gameVersion){
        gameOfWar = gameOfWarVersionOne.handleGameOfWarVersion(gameVersion);
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
        System.out.println();
        printGame.printWinnerOfGame(gameOfWar);
        System.out.println();
        printGame.printScore(gameOfWar.players);
        System.out.println();
    }

}
