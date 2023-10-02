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

    public static void play() {
        setupGame();
        for (int i = 0; i < numOfRounds; i++) {
            Player winner = createPlayerObject();
            winner = playRound();
            if (winner == null) {
                winner = playWar();
            }
            if(gameEnded(winner)){
                printStatus(winner);
                break;
            }
            printStatus(winner);
            printScore();
        }
        printScore();
        declareWinner();
    }

    private static void setupGame(){
        gameOfWar.setupGame.setup(gameOfWar.players);
    }

    private static Player createPlayerObject(){
        return new PlayerVersionOne();//change this to be variable
    }

    private static Player playRound(){
        return gameOfWar.gameRound.playRound(gameOfWar.players);
    }

    private static Player playWar(){
        printGame.printCurrentStatusWar(gameOfWar);
        return gameOfWar.warRound.war(gameOfWar.players);
    }

    private static void printStatus(Player winner){
        printGame.printCurrentStatusNormal(gameOfWar, winner);
    }

    private static boolean gameEnded(Player winner){
        return gameOfWar.pointSystem.gameEnded(gameOfWar.players, winner);
    }

    private static void declareWinner(){
        Player winner = gameOfWar.pointSystem.determineWinner(gameOfWar.players);
        if(winner != null){
            System.out.println(winner.getName() + " wins!");
        }
        else{
            System.out.println("tie!");
        }
        System.exit(0);
    }

    private static void printScore(){
        printGame.printScore(gameOfWar.players);
    }
}
