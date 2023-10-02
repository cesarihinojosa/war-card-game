package hw2.gamecomponents;

import hw2.coreobjects.Player;

public class PointSystemVersionTwo implements PointSystem{

    final int NUMBER_OF_PLAYERS = 2;
    
    @Override
    public boolean gameEnded(Player[] players, Player winner) {
        if(checkIfGameOver(players) || checkIfGameEndedInTie(winner)){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean checkIfGameOver(Player[] players){
        for(int i = 0; i < players.length; i++){
            if(players[i].getPile().size() == 0){
                return true;
            }
        }
        return false;
    }

    private boolean checkIfGameEndedInTie(Player winner){
        if(winner == null){
            return true;
        }
        return false;
    }

    @Override
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
