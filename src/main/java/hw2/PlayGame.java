package hw2;

import hw2.coreobjects.Player;
import hw2.coreobjects.PlayerVersionOne;
import hw2.gameversions.GameOfWar;
import hw2.gameversions.GameOfWarVersionOne;
import hw2.gameversions.GameOfWarVersionThree;
import hw2.gameversions.GameOfWarVersionTwo;

public class PlayGame {

    static private int gameVersion;
    static private int numOfRounds;
    static private int shuffleSeed;

    static GameOfWar gameOfWar;
    static GameOfWar gameOfWarVersionOne;
    static GameOfWar gameOfWarVersionTwo;
    static GameOfWar gameOfWarVersionThree;

    public static void play(String[] args) {
        assignCommandArgToGameVersion(args);
        createGameVersions();
        createChainOfResponsibilites();
        chooseGameVersionBasedOnCommandArgs(gameVersion);
        assignCommandArgsToRemainingValues(args);
        playEntireGame();
    }

    private static void assignCommandArgToGameVersion(String[] args){
        gameVersion = Integer.parseInt(args[0]);
    }

    private static void createGameVersions(){
        gameOfWarVersionOne = new GameOfWarVersionOne();
        gameOfWarVersionTwo = new GameOfWarVersionTwo();
        gameOfWarVersionThree = new GameOfWarVersionThree();
    }

    private static void createChainOfResponsibilites(){
        gameOfWarVersionOne.setNextGameOfWar(gameOfWarVersionTwo);
        gameOfWarVersionTwo.setNextGameOfWar(gameOfWarVersionThree);
        gameOfWarVersionThree.setNextGameOfWar(null);
    }

    private static void chooseGameVersionBasedOnCommandArgs(int gameVersion){
        gameOfWar = gameOfWarVersionOne.handleGameOfWarVersion(gameVersion);
    }

    private static void assignCommandArgsToRemainingValues(String[] args){
        if(gameOfWar.limitOnRounds == true){
            numOfRounds = Integer.parseInt(args[1]);
            shuffleSeed = Integer.parseInt(args[2]);
        }
        else{
            shuffleSeed = Integer.parseInt(args[1]);
        }
    }

    private static void playEntireGame(){
        setupGame(shuffleSeed);
        int i = 0;
        while(i < numOfRounds || gameOfWar.limitOnRounds == false){

            Player winner = createPlayerObject();
            winner = playRound();
            if (winner == null) {
                PrintGame.printCardsInPlayWar(gameOfWar);
                winner = playWar();
            }
            if (gameEnded(winner)) {
                printEndOfGameInfo();
                break;
            }
            printGameInfo(winner);
            
            i++;
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
        PrintGame.printCardsInPlay(gameOfWar);
        PrintGame.printWinnerOfRound(gameOfWar.players, winner);
        PrintGame.printScore(gameOfWar.players);
        System.out.println();
    }

    private static void printEndOfGameInfo() {
        PrintGame.printCardsInPlay(gameOfWar);
        System.out.println();
        PrintGame.printWinnerOfGame(gameOfWar);
        System.out.println();
        PrintGame.printScore(gameOfWar.players);
        System.out.println();
        System.out.println("seed: " + shuffleSeed);
    }

}