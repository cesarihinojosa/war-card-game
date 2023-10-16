package app.gameversions;

import app.coreobjects.Player;
import app.gamecomponents.GameRound;
import app.gamecomponents.PointSystem;
import app.gamecomponents.SetupGame;
import app.gamecomponents.WarRound;

public abstract class GameOfWar {

    GameOfWar nextGameOfWar;

    public Player[] players;
    public SetupGame setupGame;
    public GameRound gameRound;
    public PointSystem pointSystem;
    public WarRound warRound;
    public boolean limitOnRounds;

    public abstract void setNextGameOfWar(GameOfWar nextGameOfWar);

    public abstract GameOfWar handleGameOfWarVersion(int gameOfWarVersion);
    
}
