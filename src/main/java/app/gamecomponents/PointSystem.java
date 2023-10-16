package app.gamecomponents;

import app.coreobjects.Player;

public interface PointSystem {
    
    public boolean gameEnded(Player[] players, Player winner);

    public Player determineWinner(Player[] players);

}
