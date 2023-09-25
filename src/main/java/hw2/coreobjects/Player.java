package hw2.coreobjects;

import java.util.ArrayList;
import java.util.List;

abstract public class Player {
    
    String name;
    public List<Card> pile;
    List<Card> cardsInPlay;
    Card previousCardInPlay;

    public void createPile(){
        pile = new ArrayList<Card>();
        cardsInPlay = new ArrayList<Card>();
    }

    public String getName(){
        return name;
    }

    public List<Card> getPile(){
        return pile;
    }

    void setPile(List<Card> pile){
        this.pile = pile;
    }

    public void playCard(){
        Card card = new Card();
        card = pile.get(pile.size() - 1);
        setCardInPlay(card);
        pile.remove(card);
    }

    public Card getCardInPlay(){
        return cardsInPlay.get(cardsInPlay.size() - 1);
    }

    public void setCardInPlay(Card cardInPlay){
        cardsInPlay.add(cardInPlay);
    }

    public void clearCardsInPlay(){
        setPreviousCardInPlay(cardsInPlay.get(cardsInPlay.size() - 1));
        cardsInPlay.clear();
    }

    public Card getPreviousCardInPlay(){
        return previousCardInPlay;
    }

    public void setPreviousCardInPlay(Card previousCardInPlay){
        this.previousCardInPlay = previousCardInPlay;
    }

    public abstract void addToPile(Card card);

}
