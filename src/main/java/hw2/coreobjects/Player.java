package hw2.coreobjects;

import java.util.ArrayList;
import java.util.List;

abstract public class Player {
    
    String name;
    List<Card> pile;

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

    public void printPile(List<Card> pile){
        for(int i = 0; i < pile.size(); i++){
            System.out.println(pile.get(i).getNameOfCard());
        }
    }

    public abstract void addToPile(Card card);

    public void turnCardOver(Card card){
    }

}
