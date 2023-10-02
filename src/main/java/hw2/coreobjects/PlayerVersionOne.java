package hw2.coreobjects;

import java.util.ArrayList;
import java.util.List;

public class PlayerVersionOne extends Player{

    public PlayerVersionOne(){
        pile = new ArrayList<Card>();
        cardsInPlay = new ArrayList<Card>();
    }

    @Override
    public void addCardToPile(Card cardWon) {
        addCardToBottomOfPile(cardWon);
    }

    @Override
    public void addManyCardsToPile(List<Card> cardsWon) {
        addManyCardsToBottomOfPile(cardsWon);
    }

    public void addCardToBottomOfPile(Card card){
        pile.add(0, card);
    }

    public void addManyCardsToBottomOfPile(List<Card> cardsWon){
        pile.addAll(0, cardsWon);
    }

    @Override
    public int getPoints() {
        return pile.size();
    }
}
