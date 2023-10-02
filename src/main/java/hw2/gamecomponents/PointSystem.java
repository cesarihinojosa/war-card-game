package hw2.gamecomponents;

import hw2.coreobjects.Player;

public interface PointSystem {
    
    public boolean gameEnded(Player[] players, Player winner);

    public Player determineWinner(Player[] players);

}
