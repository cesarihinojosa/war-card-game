package hw2;

import hw2.coreobjects.Player;
import hw2.gameversions.GameOfWar;

public class PrintGame {

    public void printCurrentStatusNormal(GameOfWar gameOfWar, Player winner) {
        for (int i = 0; i < gameOfWar.players.length; i++) {
            System.out.println(gameOfWar.players[i].getName() +
                    " plays " +
                    gameOfWar.players[i].getPreviousCardInPlay().getNameOfCard());
        }
        System.out.println(winner.getName() + " wins the round");
    }

    public void printCurrentStatusWar(GameOfWar gameOfWar) {
        for (int i = 0; i < gameOfWar.players.length; i++) {
            System.out.println(gameOfWar.players[i].getName() +
                    " plays " +
                    gameOfWar.players[i].getCardInPlay().getNameOfCard());
        }
        System.out.println("****WAR****");
    }

    public void printScore(Player[] players){
        for(int i = 0; i < players.length; i++){
            System.out.println(players[i].getName() + " has a score of " + 
            players[i].getPoints());
        }
        System.out.println();
    }

}
