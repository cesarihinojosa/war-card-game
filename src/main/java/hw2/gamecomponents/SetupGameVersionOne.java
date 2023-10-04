package hw2.gamecomponents;

import hw2.coreobjects.Dealer;
import hw2.coreobjects.Player;

public class SetupGameVersionOne implements SetupGame{

    @Override
    public void setup(Player[] players, int shuffleSeed) {
        Dealer dealer = Dealer.getInstance();
        dealer.shuffleDeck(shuffleSeed);
        dealer.dealCards(players, players.length);
    }
    
}
