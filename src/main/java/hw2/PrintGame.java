package hw2;

import hw2.coreobjects.Player;
import hw2.gameversions.GameOfWar;

public class PrintGame {

    public void printCurrentStatus(GameOfWar gameOfWar, int indexOfWinner) {
        System.out.println();
        for (int i = 0; i < gameOfWar.players.length; i++) {
            System.out.println(gameOfWar.players[i].getName() +
                    " plays " +
                    gameOfWar.players[i].getPreviousCardInPlay().getNameOfCard());

        }
        if (indexOfWinner < 0) {
            System.out.println("****WAR****");
        } else {
            System.out.println(gameOfWar.players[indexOfWinner].getName() +
                    " wins the round");
        }
    }

    public void printCurrentStatus(GameOfWar gameOfWar, Player winner) {
        System.out.println();
        for (int i = 0; i < gameOfWar.players.length; i++) {
            System.out.println(gameOfWar.players[i].getName() +
                    " plays " +
                    gameOfWar.players[i].getPreviousCardInPlay().getNameOfCard());

        }

        System.out.println(winner.getName() +
                " wins the round");
    }

}
