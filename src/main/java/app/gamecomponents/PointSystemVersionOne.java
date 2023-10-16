package app.gamecomponents;

import app.coreobjects.Player;

public class PointSystemVersionOne implements PointSystem {

    final int NUMBER_OF_PLAYERS = 2;

    public boolean gameEnded(Player[] players, Player winner) {
        if (checkIfPlayerHasWon(players) || checkIfGameEndedInTie(winner)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkIfPlayerHasWon(Player[] players) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].getPoints() == 52) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfGameEndedInTie(Player winner) {
        if (winner == null) {
            return true;
        }
        return false;
    }

    public Player determineWinner(Player[] players) {
        Player winner = null;
        winner = determinePlayerWithHighestPoints(players);
        return winner;
    }

    private Player determinePlayerWithHighestPoints(Player[] players){
        int maxPoints = 0;
        Player winner = null;
        for(int i = 0; i < NUMBER_OF_PLAYERS; i++){
            if(players[i].getPoints() > maxPoints){
                maxPoints = players[i].getPoints();
                winner = players[i];
            }
            else if(players[i].getPoints() == maxPoints && maxPoints != 0){
                winner =  null;
            }
        }
        return winner;
    }

}
