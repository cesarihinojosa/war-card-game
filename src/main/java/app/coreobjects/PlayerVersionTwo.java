package app.coreobjects;

import java.util.ArrayList;
import java.util.List;

public class PlayerVersionTwo extends Player {

    List<Card> pointsPile;

    public PlayerVersionTwo(){
        pile = new ArrayList<Card>();
        cardsInPlay = new ArrayList<Card>();
        pointsPile = new ArrayList<Card>();
    }

    @Override
    public void addCardToPile(Card cardWon) {
        addCardToPointsPile(cardWon);
    }

    @Override
    public void addManyCardsToPile(List<Card> cardsWon) {
        addManyCardsToPointsfPile(cardsWon);
    }

    public void addCardToPointsPile(Card card){
        pointsPile.add(card);
    }

    public void addManyCardsToPointsfPile(List<Card> cardsWon){
        pointsPile.addAll(cardsWon);
    }

    @Override
    public int getPoints() {
        return pointsPile.size();
    }



}
