package hw2.coreobjects;

import java.util.List;

abstract public class Player {
    
    String name;
    List<Card> pile;
    List<Card> cardsInPlay;
    Card previousCardInPlay;
    int points = 0;

    public abstract void addCardToPile(Card cardWon);

    public abstract void addManyCardsToPile(List<Card> cardsWon);

    public void playCard(){
        Card card = new Card();
        card = pile.get(pile.size() - 1);
        setCardInPlay(card);
        pile.remove(card);
    }

    public void clearCardsInPlay(){
        setPreviousCardInPlay(cardsInPlay.get(cardsInPlay.size() - 1));
        cardsInPlay.clear();
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Card> getPile(){
        return pile;
    }

    void setPile(List<Card> pile){
        this.pile = pile;
    }

    public List<Card> getAllCardsInPlay(){
        return cardsInPlay;
    }

    public Card getCardInPlay(){
        return cardsInPlay.get(cardsInPlay.size() - 1);
    }

    public void setCardInPlay(Card cardInPlay){
        cardsInPlay.add(cardInPlay);
    }

    public Card getPreviousCardInPlay(){
        return previousCardInPlay;
    }

    public void setPreviousCardInPlay(Card previousCardInPlay){
        this.previousCardInPlay = previousCardInPlay;
    }

    public int getPoints(){
        return points;
    }

    public void setPoints(int points){
        this.points = points;
    }

}
