package hw2;

import hw2.coreobjects.Player;
import hw2.gameversions.GameOfWar;

public class PrintGame {

    public void printCardsInPlay(GameOfWar gameOfWar) {
        for (int i = 0; i < gameOfWar.players.length; i++) {
            System.out.println(gameOfWar.players[i].getName() +
                    " plays " +
                    gameOfWar.players[i].getPreviousCardInPlay().getNameOfCard());
        }
    }

    public void printCardsInPlayWar(GameOfWar gameOfWar) {
        for (int i = 0; i < gameOfWar.players.length; i++) {
            System.out.println(gameOfWar.players[i].getName() +
                    " plays " +
                    gameOfWar.players[i].getCardInPlay().getNameOfCard());
        }
        System.out.println("****WAR****");
    }

    public void printWinnerOfRound(Player[] players, Player winner){
        System.out.println(winner.getName() + " wins the round");
    }

    public void printWinnerOfGame(GameOfWar gameOfWar){
        Player winner = gameOfWar.pointSystem.determineWinner(gameOfWar.players);
        if(winner != null){
            System.out.println(winner.getName() + " WINS THE GAME!");
        }
        else{
            System.out.println("TIE!!");
        }
    }

    public void printScore(Player[] players){
        for(int i = 0; i < players.length; i++){
            System.out.println(players[i].getName() + " has a score of " + 
            players[i].getPoints());
        }
    }

}
