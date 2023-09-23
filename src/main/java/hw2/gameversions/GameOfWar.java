package hw2.gameversions;

import hw2.coreobjects.Player;
import hw2.gamecomponents.GameRound;
import hw2.gamecomponents.PointSystem;
import hw2.gamecomponents.SetupGame;
import hw2.gamecomponents.WarRound;

public abstract class GameOfWar {

    public Player[] players;
    public SetupGame setupGame;
    public GameRound gameRound;
    public PointSystem pointSystem;
    public WarRound warRound;
    
}
