package app.gamecomponents;

import app.coreobjects.Dealer;
import app.coreobjects.Player;

public class SetupGameVersionOne implements SetupGame{

    public void setup(Player[] players, int shuffleSeed) {
        Dealer dealer = Dealer.getInstance();
        dealer.shuffleDeck(shuffleSeed);
        dealer.dealCards(players, players.length);
    }
    
}
