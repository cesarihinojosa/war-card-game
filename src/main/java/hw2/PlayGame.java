package hw2;

import hw2.coreobjects.Player;
import hw2.coreobjects.PlayerVersionOne;
import hw2.gameversions.GameOfWar;
import hw2.gameversions.GameOfWarVersionOne;

public class PlayGame {

    static int numOfRounds = 400;// TODO: change this to depend on the command arguments
    static GameOfWar gameOfWar = new GameOfWarVersionOne();
    static PrintGame printGame = new PrintGame();

    public static void play() {
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
        }
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

    private static void checkIfGameEnded(Player winner){
        if(gameOfWar.pointSystem.gameEnded(gameOfWar.players, winner)){
            System.exit(0);
        }
    }

    private static void setPoints(){
        gameOfWar.pointSystem.setPoints(gameOfWar.players);
    }

    private static void printScore(){
        printGame.printScore(gameOfWar.players);
    }
}
