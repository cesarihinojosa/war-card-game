package hw2.coreobjects;

import java.util.ArrayList;
import java.util.List;

abstract public class Player {
    
    String name;
    List<Card> pile;
    Card cardInPlay;
    Card previousCardInPlay;

    public void createPile(){
        pile = new ArrayList<Card>();
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
        return cardInPlay;
    }

    public void setCardInPlay(Card cardInPlay){
        setPreviousCardInPlay(this.cardInPlay);
        this.cardInPlay = cardInPlay;
    }

    public Card getPreviousCardInPlay(){
        return previousCardInPlay;
    }

    public void setPreviousCardInPlay(Card previousCardInPlay){
        this.previousCardInPlay = previousCardInPlay;
    }

    public void printPile(List<Card> pile){
        if(pile.size() == 0){
            System.out.println("<<pile is empty>>");
        }
        for(int i = 0; i < pile.size(); i++){
            System.out.println(pile.get(i).getNameOfCard());
        }
    }

    public abstract void addToPile(Card card);

}
