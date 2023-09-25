package hw2;

import hw2.gameversions.GameOfWar;

public class PrintGame {

    public void printCurrentStatus(GameOfWar gameOfWar, int indexOfWinner) {
        for (int i = 0; i < gameOfWar.players.length; i++) {
            System.out.println(gameOfWar.players[i].getName() +
                    "plays " + gameOfWar.players[i].getPreviousCardInPlay());
        }
        System.out.println(gameOfWar.players[indexOfWinner] +
                "wins the round");
    }

}
