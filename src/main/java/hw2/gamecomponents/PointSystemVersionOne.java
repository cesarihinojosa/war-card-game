package hw2.gamecomponents;

import hw2.coreobjects.Player;

public class PointSystemVersionOne implements PointSystem{

    @Override
    public void setPoints(Player[] players){
        for(int i = 0; i < players.length; i++){
            players[i].setPoints(players[i].getPile().size());
        }
    }

    @Override
    public boolean gameEnded(Player[] players, Player winner) {
        if(checkIfPlayerHasWon(players) || checkIfGameEndedInTie(winner)){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean checkIfPlayerHasWon(Player[] players){
        for(int i = 0; i < players.length; i++){
            if(players[i].getPoints() == 52){
                System.out.println(players[i].getName() + " WON!");
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
    
}
