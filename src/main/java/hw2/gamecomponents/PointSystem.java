package hw2.gamecomponents;

import hw2.coreobjects.Player;

public interface PointSystem {

    public void setPoints(Player[] players);
    
    public boolean gameEnded(Player[] players, Player winner);

}
