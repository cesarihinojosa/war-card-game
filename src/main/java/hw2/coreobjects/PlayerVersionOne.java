package hw2.coreobjects;

import java.util.ArrayList;

public class PlayerVersionOne extends Player{

    public PlayerVersionOne(String name){
        this.name = name;
        pile = new ArrayList<Card>();
        cardsInPlay = new ArrayList<Card>();
    }

    @Override
    public void addToPile(Card card) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToPile'");
    }
    
}
