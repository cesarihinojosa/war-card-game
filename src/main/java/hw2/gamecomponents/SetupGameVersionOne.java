package hw2.gamecomponents;

import hw2.coreobjects.Dealer;
import hw2.coreobjects.Player;

public class SetupGameVersionOne implements SetupGame{

    @Override
    public void setup(Player[] players) {
        Dealer dealer = Dealer.getInstance();
        dealer.shuffleDeck();
        //dealer.dealCards();
    }
    
}
