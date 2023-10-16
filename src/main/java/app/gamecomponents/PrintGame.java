package app.gamecomponents;

import app.coreobjects.Player;
import app.gameversions.GameOfWar;

public class PrintGame {

    public static void printCardsInPlay(GameOfWar gameOfWar) {
        for (int i = 0; i < gameOfWar.players.length; i++) {
            System.out.println(gameOfWar.players[i].getName() +
                    " plays " +
                    gameOfWar.players[i].getPreviousCardInPlay().getNameOfCard());
        }
    }

    public static void printCardsInPlayWar(GameOfWar gameOfWar) {
        for (int i = 0; i < gameOfWar.players.length; i++) {
            System.out.println(gameOfWar.players[i].getName() +
                    " plays " +
                    gameOfWar.players[i].getCardInPlay().getNameOfCard());
        }
        System.out.println("****WAR****");
    }

    public static void printWinnerOfRound(Player[] players, Player winner){
        System.out.println(winner.getName() + " wins the round");
    }

    public static void printWinnerOfGame(GameOfWar gameOfWar){
        Player winner = gameOfWar.pointSystem.determineWinner(gameOfWar.players);
        if(winner != null){
            System.out.println(winner.getName() + " WINS THE GAME!");
        }
        else{
            System.out.println("TIE!!");
        }
    }

    public static void printScore(Player[] players){
        for(int i = 0; i < players.length; i++){
            System.out.println(players[i].getName() + " has a score of " + 
            players[i].getPoints());
        }
    }

}
